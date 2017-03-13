package com.rbs.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbs.domains.Domain;

@Entity
@Table(name = "stock_details")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockDetail implements Domain, Serializable {

	@Id
	@JsonProperty("t")
	@Column(name = "symbol")
	private String ticker;
	
	@JsonProperty("e")
	@Column(name = "exchange")
	private String exchange;
	
	@JsonProperty("l")
	@Column(name = "last_price")
	private double lastPrice;
	
	@JsonProperty("lt_dts")
	@Column(name = "last_trade_date_time")
	private Date lastTradeDateTime;
	
	@JsonProperty("c")
	@Column(name = "change")
	private double change;
	
	@JsonProperty("cp")
	@Column(name = "change_percentage")
	private double changePercentage;
	
	@JsonProperty("el")
	@Column(name = "after_hours_last_price")
	private double afterHoursLastPrice;
	
	@JsonProperty("elt")
	@Column(name = "after_hours_trade_time")
	private Date afterHoursTradeTime;
	
	@JsonProperty("div")
	@Column(name = "divident")
	private double dividend;
	
	@JsonProperty("yld")
	@Column(name = "dividend_yield")
	private double dividendYield;
	
	public String getTicker() {
		return ticker;
	}
	public StockDetail setTicker(String ticker) {
		this.ticker = ticker;
		return this;
	}
	public String getExchange() {
		return exchange;
	}
	public StockDetail setExchange(String exchange) {
		this.exchange = exchange;
		return this;
	}
	public double getLastPrice() {
		return lastPrice;
	}
	public StockDetail setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
		return this;
	}
	public Date getLastTradeDateTime() {
		return lastTradeDateTime;
	}
	public StockDetail setLastTradeDateTime(Date lastTradeDateTime) {
		this.lastTradeDateTime = lastTradeDateTime;
		return this;
	}
	public double getChange() {
		return change;
	}
	public StockDetail setChange(double change) {
		this.change = change;
		return this;
	}
	public double getChangePercentage() {
		return changePercentage;
	}
	public StockDetail setChangePercentage(double changePercentage) {
		this.changePercentage = changePercentage;
		return this;
	}
	public double getAfterHoursLastPrice() {
		return afterHoursLastPrice;
	}
	public StockDetail setAfterHoursLastPrice(double afterHoursLastPrice) {
		this.afterHoursLastPrice = afterHoursLastPrice;
		return this;
	}
	public Date getAfterHoursTradeTime() {
		return afterHoursTradeTime;
	}
	public StockDetail setAfterHoursTradeTime(Date afterHoursTradeTime) {
		this.afterHoursTradeTime = afterHoursTradeTime;
		return this;
	}
	public double getDividend() {
		return dividend;
	}
	public StockDetail setDividend(double dividend) {
		this.dividend = dividend;
		return this;
	}
	public double getDividendYield() {
		return dividendYield;
	}
	public StockDetail setDividendYield(double dividendYield) {
		this.dividendYield = dividendYield;
		return this;
	}
	@Override
	public String toString() {
		return "StockDetails [ticker=" + ticker + ", exchange=" + exchange + ", lastPrice=" + lastPrice
				+ ", lastTradeDateTime=" + lastTradeDateTime + ", change=" + change + ", changePercentage="
				+ changePercentage + ", afterHoursLastPrice=" + afterHoursLastPrice + ", afterHoursTradeTime="
				+ afterHoursTradeTime + ", dividend=" + dividend + ", dividendYield=" + dividendYield + "]";
	}
	@Override
	public boolean equals(Object obj) {
		StockDetail detail = (StockDetail) obj;
		if(detail.lastPrice == this.lastPrice)
			return true;
		else return false;
	}	
	
}
