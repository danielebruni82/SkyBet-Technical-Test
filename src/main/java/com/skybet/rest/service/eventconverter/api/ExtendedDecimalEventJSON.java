package com.skybet.rest.service.eventconverter.api;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtendedDecimalEventJSON extends DecimalEventJSON implements Serializable{

	private static final long serialVersionUID = 1L;

	private double stake;

	private int transaction_id;

	public double getStake() {
		return stake;
	}

	public void setStake(double stake) {
		this.stake = stake;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}


	
}
