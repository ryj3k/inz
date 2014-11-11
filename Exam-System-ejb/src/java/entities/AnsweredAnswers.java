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
@Table(name = "answered_answers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnsweredAnswers.findAll", query = "SELECT a FROM AnsweredAnswers a"),
    @NamedQuery(name = "AnsweredAnswers.findByIdansweredAnswers", query = "SELECT a FROM AnsweredAnswers a WHERE a.idansweredAnswers = :idansweredAnswers"),
    @NamedQuery(name = "AnsweredAnswers.findByCorrect", query = "SELECT a FROM AnsweredAnswers a WHERE a.correct = :correct"),
    @NamedQuery(name = "AnsweredAnswers.findByChosen", query = "SELECT a FROM AnsweredAnswers a WHERE a.chosen = :chosen")})
public class AnsweredAnswers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idanswered_answers")
    private Integer idansweredAnswers;
    @Lob
    @Size(max = 65535)
    @Column(name = "answer")
    private String answer;
    @Column(name = "correct")
    private Integer correct;
    @Column(name = "chosen")
    private Integer chosen;
    @JoinTable(name = "answered_question_has_answered_answers", joinColumns = {
        @JoinColumn(name = "idanswered_answers", referencedColumnName = "idanswered_answers")}, inverseJoinColumns = {
        @JoinColumn(name = "idanswered_questions", referencedColumnName = "idanswered_questions")})
    @ManyToMany
    private Collection<AnsweredQuestions> answeredQuestionsCollection;

    public AnsweredAnswers() {
    }

    public AnsweredAnswers(Integer idansweredAnswers) {
        this.idansweredAnswers = idansweredAnswers;
    }

    public Integer getIdansweredAnswers() {
        return idansweredAnswers;
    }

    public void setIdansweredAnswers(Integer idansweredAnswers) {
        this.idansweredAnswers = idansweredAnswers;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public Integer getChosen() {
        return chosen;
    }

    public void setChosen(Integer chosen) {
        this.chosen = chosen;
    }

    @XmlTransient
    public Collection<AnsweredQuestions> getAnsweredQuestionsCollection() {
        return answeredQuestionsCollection;
    }

    public void setAnsweredQuestionsCollection(Collection<AnsweredQuestions> answeredQuestionsCollection) {
        this.answeredQuestionsCollection = answeredQuestionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idansweredAnswers != null ? idansweredAnswers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnsweredAnswers)) {
            return false;
        }
        AnsweredAnswers other = (AnsweredAnswers) object;
        if ((this.idansweredAnswers == null && other.idansweredAnswers != null) || (this.idansweredAnswers != null && !this.idansweredAnswers.equals(other.idansweredAnswers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AnsweredAnswers[ idansweredAnswers=" + idansweredAnswers + " ]";
    }
    
}
