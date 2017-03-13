package com.rbs.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbs.pojo.StockDetail;

@Component
public class StockParser {

	public List<StockDetail> parse(String data){
		List<StockDetail> list = new ArrayList();
		try {
			JSONArray jsonArray = new JSONArray(sanitize(data));
			jsonArray.forEach(obj -> {				
				StockDetail detail = null;
				try {
					detail = parse((JSONObject) obj);
				} catch (Exception e) {				
					e.printStackTrace();
				}
				list.add(detail);
			});
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return list;
	}
	
	private StockDetail parse(JSONObject jsonObject) throws Exception {		
		ObjectMapper mapper = new ObjectMapper();
		StockDetail detail = mapper.readValue(jsonObject.toString(), StockDetail.class);
		
		return detail;
	}
	
	private String sanitize(String data){
		return data.replaceAll("//", "");
	}
	
}
