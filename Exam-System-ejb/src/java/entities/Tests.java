/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ryj3k
 */
@Entity
@Table(name = "tests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tests.findAll", query = "SELECT t FROM Tests t"),
    @NamedQuery(name = "Tests.findByIdtests", query = "SELECT t FROM Tests t WHERE t.idtests = :idtests"),
    @NamedQuery(name = "Tests.findByName", query = "SELECT t FROM Tests t WHERE t.name = :name"),
    @NamedQuery(name = "Tests.findByTime", query = "SELECT t FROM Tests t WHERE t.time = :time"),
    @NamedQuery(name = "Tests.findByPassword", query = "SELECT t FROM Tests t WHERE t.password = :password"),
    @NamedQuery(name = "Tests.findByNumberOfQuestions", query = "SELECT t FROM Tests t WHERE t.numberOfQuestions = :numberOfQuestions"),
    @NamedQuery(name = "Tests.findByActive", query = "SELECT t FROM Tests t WHERE t.active = :active"),
    @NamedQuery(name = "Tests.findByArchived", query = "SELECT t FROM Tests t WHERE t.archived = :archived")})
public class Tests implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtests")
    private Integer idtests;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "time")
    private Integer time;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Column(name = "number_of_questions")
    private Integer numberOfQuestions;
    @Column(name = "active")
    private Integer active;
    @Column(name = "archived")
    private Integer archived;
    @ManyToMany(mappedBy = "testsCollection")
    private Collection<Question> questionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtests")
    private Collection<AnsweredTest> answeredTestCollection;
    @JoinColumn(name = "author", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private Users author;

    public Tests() {
    }

    public Tests(Integer idtests) {
        this.idtests = idtests;
    }

    public Integer getIdtests() {
        return idtests;
    }

    public void setIdtests(Integer idtests) {
        this.idtests = idtests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(Integer numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getArchived() {
        return archived;
    }

    public void setArchived(Integer archived) {
        this.archived = archived;
    }

    @XmlTransient
    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }

    @XmlTransient
    public Collection<AnsweredTest> getAnsweredTestCollection() {
        return answeredTestCollection;
    }

    public void setAnsweredTestCollection(Collection<AnsweredTest> answeredTestCollection) {
        this.answeredTestCollection = answeredTestCollection;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtests != null ? idtests.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tests)) {
            return false;
        }
        Tests other = (Tests) object;
        if ((this.idtests == null && other.idtests != null) || (this.idtests != null && !this.idtests.equals(other.idtests))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tests[ idtests=" + idtests + " ]";
    }
    
}
