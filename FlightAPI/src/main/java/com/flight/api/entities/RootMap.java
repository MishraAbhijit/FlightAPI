package com.flight.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RootMap {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String day;
	private String source;
	private String destination;
	private String uniqueCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	@Override
	public String toString() {
		return "Shedule [id=" + id + ", day=" + day + ", source=" + source + ", destination=" + destination
				+ ", uniqueCode=" + uniqueCode + "]";
	}

}
