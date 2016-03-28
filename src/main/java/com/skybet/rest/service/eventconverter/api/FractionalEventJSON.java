package com.skybet.rest.service.eventconverter.api;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FractionalEventJSON implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private long bet_id;

	@JsonProperty
	private String event;

	@JsonProperty
	private String name;

	@JsonProperty
	private FractionalOdd odds;

	@JsonProperty
	private double stake;

	@JsonProperty
	private int transaction_id;

	public long getBet_id() {
		return bet_id;
	}

	public void setBet_id(long bet_id) {
		this.bet_id = bet_id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FractionalOdd getOdds() {
		return odds;
	}

	public void setOdds(FractionalOdd odds) {
		this.odds = odds;
	}

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


