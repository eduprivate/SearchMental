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
@Table(name="STATISTIC_RESULT")
public class StatisticAnalizeResult implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="TERM")
	private String term;
	
	@Column(name="NEGATIVE")
	private Integer negative = new Integer(0);
	
	@Column(name="POSITIVE")
	private Integer positive = new Integer(0);
	
	@Column(name="COUNT")
	private Double count = new Double(1D);
	
	@Column(name="COUNT_NEGATIVE")
	private Double countNegative = new Double(0D);
	
	@Column(name="COUNT_POSITIVE")
	private Double countPositive = new Double(0D);
	
	@Column(name="SCORE")
	private Integer score = new Integer(0);
	
	@Column(name="POSITIVE_PERCENT")
	private Double positivePercent = new Double(0D);
	
	@Column(name="NEGATIVE_PERCENTE")
	private Double negativePercent = new Double(0D);
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE", columnDefinition = "DATETIME" )
	private Date date;
	
	public StatisticAnalizeResult(String term, Integer negative, Integer positive,
			Double count, Double countNegative, Double countPositive) {
		super();
		this.term = term;
		this.negative = negative;
		this.positive = positive;
		this.count = count;
		this.countNegative = countNegative;
		this.countPositive = countPositive;
		
		if (this.count == 0)
			this.count = 1D;
		
		this.positivePercent = new Double( this.countPositive / this.count ) * 100;
		this.negativePercent = new Double( this.countNegative / this.count ) * 100;
		Calendar calendar = Calendar.getInstance();
		this.date = calendar.getTime();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public Double getCountNegative() {
		return countNegative;
	}

	public void setCountNegative(Double countNegative) {
		this.countNegative = countNegative;
	}

	public Double getCountPositive() {
		return countPositive;
	}

	public void setCountPositive(Double countPositive) {
		this.countPositive = countPositive;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Double getPositivePercent() {
		return positivePercent;
	}

	public void setPositivePercent(Double positivePercent) {
		this.positivePercent = positivePercent;
	}

	public Double getNegativePercent() {
		return negativePercent;
	}

	public void setNegativePercent(Double negativePercent) {
		this.negativePercent = negativePercent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTerm() {
		return term;
	}
	
	public void setTerm(String term) {
		this.term = term;
	}
	
}