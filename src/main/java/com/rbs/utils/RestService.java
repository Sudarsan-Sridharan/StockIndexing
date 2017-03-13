package com.rbs.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rbs.pojo.StockDetail;

@Component
public class RestService {

	public List<StockDetail> getStockBySymbol(List<String> symbols){
		return getStockBySymbol(commaSeperated(symbols));		
	}
	
	private List<StockDetail> getStockBySymbol(String symbols){
		String response = getStock(symbols);
		List<StockDetail> list = new StockParser().parse(response);
		return list;
	}
	
	private List<StockDetail> getStockByName(String names){
		//System.out.println(getStock(names));
		return null;
	}
	
	public static void main(String[] args) {
		RestService service = new RestService();
		service.getStockBySymbol(Arrays.asList("AAPL", "GOOG"));
	}
	
	private String getStock(String param){
		try {
			final String u = "http://finance.google.com/finance/info?client=ig&q=NASDAQ%3A" + param;
			URL url = new URL(u);
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							url.openConnection().getInputStream()));
			StringBuilder response = new StringBuilder(); 
			String line = "";
			while((line = reader.readLine()) != null)
				response.append(line);
			
			return response.toString();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	private String commaSeperated(List<String> list){
		String result = "";
		for(int i = 0; i < list.size(); i++){
			if(i == 0) result += list.get(i);
			else result += "," + list.get(i);
		}
		
		return result;
	}
	
}
