package br.com.sentiment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	public AnalizeResult(Integer negative, Integer positive) {
		super();
		this.negative = negative;
		this.positive = positive;
		this.score = positive - negative;
	}
	
	public AnalizeResult(Integer negative, Integer positive, Integer score) {
		super();
		this.negative = negative;
		this.positive = positive;
		this.score = score;
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

	
}
