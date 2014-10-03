package br.com.sentiment.model;

import java.io.Serializable;

public class StatisticAnalizeResult implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer negative = new Integer(0);
	private Integer positive = new Integer(0);
	private Double count = new Double(1D);
	private Double countNegative = new Double(0D);
	private Double countPositive = new Double(0D);
	private Integer score = new Integer(0);
	private Double positivePercent = new Double(0D);
	private Double negativePercent = new Double(0D);
	
	
	public StatisticAnalizeResult(Integer negative, Integer positive,
			Double count, Double countNegative, Double countPositive) {
		super();
		this.negative = negative;
		this.positive = positive;
		this.count = count;
		this.countNegative = countNegative;
		this.countPositive = countPositive;
		
		if (this.count == 0)
			this.count = 1D;
		
		positivePercent = new Double( this.countPositive / this.count ) * 100;
		negativePercent = new Double( this.countNegative / this.count ) * 100;
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
	
}