/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ryj3k
 */
@Entity
@Table(name = "answered_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnsweredTest.findAll", query = "SELECT a FROM AnsweredTest a"),
    @NamedQuery(name = "AnsweredTest.findByIdansweredTest", query = "SELECT a FROM AnsweredTest a WHERE a.idansweredTest = :idansweredTest"),
    @NamedQuery(name = "AnsweredTest.findByAnswerDate", query = "SELECT a FROM AnsweredTest a WHERE a.answerDate = :answerDate"),
    @NamedQuery(name = "AnsweredTest.findByPointsTotal", query = "SELECT a FROM AnsweredTest a WHERE a.pointsTotal = :pointsTotal"),
    @NamedQuery(name = "AnsweredTest.findByPointsTotalGained", query = "SELECT a FROM AnsweredTest a WHERE a.pointsTotalGained = :pointsTotalGained")})
public class AnsweredTest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idanswered_test")
    private Integer idansweredTest;
    @Column(name = "answer_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date answerDate;
    @Column(name = "points_total")
    private Integer pointsTotal;
    @Column(name = "points_total_gained")
    private Integer pointsTotalGained;
    @ManyToMany(mappedBy = "answeredTestCollection")
    private Collection<AnsweredQuestions> answeredQuestionsCollection;
    @JoinColumn(name = "idusers", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private Users idusers;
    @JoinColumn(name = "idtests", referencedColumnName = "idtests")
    @ManyToOne(optional = false)
    private Tests idtests;

    public AnsweredTest() {
    }

    public AnsweredTest(Integer idansweredTest) {
        this.idansweredTest = idansweredTest;
    }

    public Integer getIdansweredTest() {
        return idansweredTest;
    }

    public void setIdansweredTest(Integer idansweredTest) {
        this.idansweredTest = idansweredTest;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public Integer getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(Integer pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    public Integer getPointsTotalGained() {
        return pointsTotalGained;
    }

    public void setPointsTotalGained(Integer pointsTotalGained) {
        this.pointsTotalGained = pointsTotalGained;
    }

    @XmlTransient
    public Collection<AnsweredQuestions> getAnsweredQuestionsCollection() {
        return answeredQuestionsCollection;
    }

    public void setAnsweredQuestionsCollection(Collection<AnsweredQuestions> answeredQuestionsCollection) {
        this.answeredQuestionsCollection = answeredQuestionsCollection;
    }

    public Users getIdusers() {
        return idusers;
    }

    public void setIdusers(Users idusers) {
        this.idusers = idusers;
    }

    public Tests getIdtests() {
        return idtests;
    }

    public void setIdtests(Tests idtests) {
        this.idtests = idtests;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idansweredTest != null ? idansweredTest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnsweredTest)) {
            return false;
        }
        AnsweredTest other = (AnsweredTest) object;
        if ((this.idansweredTest == null && other.idansweredTest != null) || (this.idansweredTest != null && !this.idansweredTest.equals(other.idansweredTest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AnsweredTest[ idansweredTest=" + idansweredTest + " ]";
    }
    
}
