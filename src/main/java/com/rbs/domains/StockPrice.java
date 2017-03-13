package com.rbs.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_price")
public class StockPrice implements Domain {

	@Id @GeneratedValue
	private int id;
	private String symbol;
	private double marketcap;
	
	@Column(name = "update_time")
	private Timestamp updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getMarketcap() {
		return marketcap;
	}

	public void setMarketcap(double marketcap) {
		this.marketcap = marketcap;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", symbol=" + symbol + ", marketcap=" + marketcap + ", updateTime=" + updateTime
				+ "]";
	}
}
