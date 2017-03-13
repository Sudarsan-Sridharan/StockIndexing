package com.rbs.config;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;
import org.apache.commons.jcs.access.exception.CacheException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rbs.pojo.StockDetail;

@Configuration
public class JCSConfig {

	@Bean
	public CacheAccess<String, StockDetail> jcsCache(){
		try {
			return JCS.getInstance("stockCache");
		} catch (CacheException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
}
