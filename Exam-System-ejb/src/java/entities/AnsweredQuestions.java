/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "answered_questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnsweredQuestions.findAll", query = "SELECT a FROM AnsweredQuestions a"),
    @NamedQuery(name = "AnsweredQuestions.findByIdansweredQuestions", query = "SELECT a FROM AnsweredQuestions a WHERE a.idansweredQuestions = :idansweredQuestions"),
    @NamedQuery(name = "AnsweredQuestions.findByType", query = "SELECT a FROM AnsweredQuestions a WHERE a.type = :type"),
    @NamedQuery(name = "AnsweredQuestions.findByPoints", query = "SELECT a FROM AnsweredQuestions a WHERE a.points = :points"),
    @NamedQuery(name = "AnsweredQuestions.findByPointsGained", query = "SELECT a FROM AnsweredQuestions a WHERE a.pointsGained = :pointsGained")})
public class AnsweredQuestions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idanswered_questions")
    private Integer idansweredQuestions;
    @Column(name = "type")
    private Integer type;
    @Lob
    @Size(max = 65535)
    @Column(name = "question")
    private String question;
    @Column(name = "points")
    private Integer points;
    @Column(name = "points_gained")
    private Integer pointsGained;
    @ManyToMany(mappedBy = "answeredQuestionsCollection")
    private Collection<AnsweredAnswers> answeredAnswersCollection;
    @JoinTable(name = "answered_test_has_answered_questions", joinColumns = {
        @JoinColumn(name = "idanswered_questions", referencedColumnName = "idanswered_questions")}, inverseJoinColumns = {
        @JoinColumn(name = "idanswered_test", referencedColumnName = "idanswered_test")})
    @ManyToMany
    private Collection<AnsweredTest> answeredTestCollection;

    public AnsweredQuestions() {
    }

    public AnsweredQuestions(Integer idansweredQuestions) {
        this.idansweredQuestions = idansweredQuestions;
    }

    public Integer getIdansweredQuestions() {
        return idansweredQuestions;
    }

    public void setIdansweredQuestions(Integer idansweredQuestions) {
        this.idansweredQuestions = idansweredQuestions;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPointsGained() {
        return pointsGained;
    }

    public void setPointsGained(Integer pointsGained) {
        this.pointsGained = pointsGained;
    }

    @XmlTransient
    public Collection<AnsweredAnswers> getAnsweredAnswersCollection() {
        return answeredAnswersCollection;
    }

    public void setAnsweredAnswersCollection(Collection<AnsweredAnswers> answeredAnswersCollection) {
        this.answeredAnswersCollection = answeredAnswersCollection;
    }

    @XmlTransient
    public Collection<AnsweredTest> getAnsweredTestCollection() {
        return answeredTestCollection;
    }

    public void setAnsweredTestCollection(Collection<AnsweredTest> answeredTestCollection) {
        this.answeredTestCollection = answeredTestCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idansweredQuestions != null ? idansweredQuestions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnsweredQuestions)) {
            return false;
        }
        AnsweredQuestions other = (AnsweredQuestions) object;
        if ((this.idansweredQuestions == null && other.idansweredQuestions != null) || (this.idansweredQuestions != null && !this.idansweredQuestions.equals(other.idansweredQuestions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AnsweredQuestions[ idansweredQuestions=" + idansweredQuestions + " ]";
    }
    
}
