package br.com.sentiment.model;

import java.io.Serializable;

public class Result implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer negative;
	private Integer positive;
	private Integer score;
	
	
	public Result(Integer negative, Integer positive) {
		super();
		this.negative = negative;
		this.positive = positive;
		this.score = positive - negative;
	}
	
	public Result(Integer negative, Integer positive, Integer score) {
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
