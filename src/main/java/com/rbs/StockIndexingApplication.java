package com.rbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.rbs.domains.Stock;
import com.rbs.repository.Repository;
import com.rbs.utils.DataImporter;

@SpringBootApplication
@EnableCaching
public class StockIndexingApplication implements CommandLineRunner {

	@Autowired Repository repository;
	@Autowired DataImporter dataImporter;
	
	public static void main(String[] args) {
		SpringApplication.run(StockIndexingApplication.class, args);
	}
		
	@Override
	public void run(String... arg0) throws Exception {  
		List<Stock> stocks = dataImporter.readExcel("stocks.xlsx");
		repository.insertAll(stocks);
	}

}
