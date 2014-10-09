package br.com.sentiment.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name="NRM_RESULT" )
public class AnalizeResult implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="TERM")
	private String term;
	
	@Column(name="NEGATIVE")
	private Integer negative;
	
	@Column(name="POSITIVE")
	private Integer positive;
	
	@Column(name="SCORE")
	private Integer score;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE", columnDefinition = "DATETIME" )
	private Date date;
	
	public AnalizeResult(String term, Integer negative, Integer positive) {
		super();
		this.term = term;
		this.negative = negative;
		this.positive = positive;
		this.score = positive - negative;
		Calendar calendar = Calendar.getInstance();
		this.date = calendar.getTime();
	}
	
	public AnalizeResult(Integer negative, Integer positive, Integer score) {
		super();
		this.negative = negative;
		this.positive = positive;
		this.score = score;
		this.date = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Integer getNegative() {
		return negative;
	}

	public void setNegative(Integer negative) {
		this.negative = negative;
	}

	public Integer getPositive() {
		return positive;
	}

	public void setPositive(Integer positive) {
		this.positive = positive;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
