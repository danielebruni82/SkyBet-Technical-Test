package com.skybet.rest.service.eventconverter.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FractionalEventJSON {
	@JsonProperty
	private long betId;

	@JsonProperty
	private String event;

	@JsonProperty
	private String name;

	@JsonProperty
	private FractionalOdd odd;

	@JsonProperty
	private double stake;

	@JsonProperty
	private int trasactionId;

	public long getBetId() {
		return betId;
	}

	public void setBetId(long betId) {
		this.betId = betId;
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

	public double getStake() {
		return stake;
	}

	public void setStake(double stake) {
		this.stake = stake;
	}

	public int getTrasactionId() {
		return trasactionId;
	}

	public void setTrasactionId(int trasactionId) {
		this.trasactionId = trasactionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (betId ^ (betId >>> 32));
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((odd == null) ? 0 : odd.hashCode());
		long temp;
		temp = Double.doubleToLongBits(stake);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + trasactionId;
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
		FractionalEventJSON other = (FractionalEventJSON) obj;
		if (betId != other.betId)
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (odd == null) {
			if (other.odd != null)
				return false;
		} else if (!odd.equals(other.odd))
			return false;
		if (Double.doubleToLongBits(stake) != Double.doubleToLongBits(other.stake))
			return false;
		if (trasactionId != other.trasactionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventFractionalJSON [betId=" + betId + ", event=" + event + ", name=" + name + ", odd=" + odd
				+ ", stake=" + stake + ", trasactionId=" + trasactionId + "]";
	}
}


