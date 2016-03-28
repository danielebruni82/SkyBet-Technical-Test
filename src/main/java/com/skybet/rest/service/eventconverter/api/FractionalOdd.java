package com.skybet.rest.service.eventconverter.api;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FractionalOdd implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private int numerator;
	
	@JsonProperty
	private int denominator;
	
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominator;
		result = prime * result + numerator;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FractionalOdd other = (FractionalOdd) obj;
		if (denominator != other.denominator)
			return false;
		if (numerator != other.numerator)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FractionalOdd [numerator=" + numerator + ", denominator=" + denominator + "]";
	}
	
	
	
}
