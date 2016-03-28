package com.skybet.rest.service.eventconverter.api;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DecimalEventJSON implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private long bet_id;

    @JsonProperty
    private String event;
    
    @JsonProperty
    private String name;

    @JsonProperty
	private double odds;
    

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

	public double getOdds() {
		return odds;
	}

	public void setOdds(double odds) {
		this.odds = odds;
	}





	
}
