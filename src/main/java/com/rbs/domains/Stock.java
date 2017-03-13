package com.rbs.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock implements Domain {

	@Id
	private String symbol;
	private String name;
	private double marketcap;
	private String sector;
	private String industry;
	
	@Column(name = "update_time")
	private Timestamp updateTime;
	
	public Stock(){}
	
	public Stock(String symbol, String name, double marketcap, String sector, String industry, Timestamp updateTime) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.marketcap = marketcap;
		this.sector = sector;
		this.industry = industry;
		this.updateTime = updateTime;
	}

	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarketcap() {
		return marketcap;
	}
	public void setMarketcap(double marketcap) {
		this.marketcap = marketcap;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", name=" + name + ", marketcap=" + marketcap + ", sector=" + sector
				+ ", industry=" + industry + ", updateTime=" + updateTime + "]";
	}
	
}
