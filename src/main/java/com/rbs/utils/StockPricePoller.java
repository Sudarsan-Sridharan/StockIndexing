package com.rbs.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.jcs.access.CacheAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.rbs.domains.Domain;
import com.rbs.domains.Stock;
import com.rbs.pojo.StockDetail;
import com.rbs.repository.Repository;
import com.rbs.websockets.WebSocketImpl;

/**
 * 
 * StockPricePoller will take 14 minutes to poll each stock
 * in the xlsx sheet.
 * 
 * Google API constraints: 200 records per request and 1 minute
 * time gap between every request.
 * 
 * @author arpit
 *
 */
@Component
public class StockPricePoller implements ApplicationListener<ContextRefreshedEvent>{

	final int POLLING_TIME = 1 * 60 * 1000;   // 60 seconds
	Thread pollThread = null;

	@Autowired CacheAccess stockDetailCache;
	@Autowired Repository repository;
	@Autowired WebSocketImpl websocketImpl;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		/*		System.out.println("Refershing the context............");  
		if(pollThread != null) pollThread.stop();
		System.out.println("Poll Thread stopped");  

		 */		System.out.println("Stock Polling Started !!!"); 
		 if(pollThread != null){
			 pollThread.stop();
			 System.out.println("poll thread killed!!!!");  
		 }
		 pollThread = pollStocks();  
	}

	/*@Override
	public void run(String... arg0) throws Exception { 
		System.out.println("Stock Polling Started !!!");

		if(pollThread == null){ 

			pollThread = pollStocks();
		}else {
			System.out.println("Prevented from starting new polling thread!!!!");
		}

	}*/

	/*public static void main(String[] args) {
		StockPricePoller poller = new StockPricePoller();
		poller.pollStocks();
	}*/

	private Thread pollStocks(){
		Thread t = new Thread(() -> {
			DataImporter importer = new DataImporter();
			List<Stock> list = importer.readExcel("stocks.xlsx");
			while(true){				
				List<String> symbols = new ArrayList();
				list.forEach(stock -> symbols.add(stock.getSymbol()));
				RestService service = new RestService();

				int start = 0, end = 199;
				while(start <= end - 1){
					List<StockDetail> details = service.getStockBySymbol(symbols.subList(start, end));
					details.forEach(System.out::println);
					maintainCache(details);
					start += 200;
					end += 200;
					try {Thread.sleep(POLLING_TIME);} catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		});
		t.start();
		return t;
	}

	private Thread maintainCache(List<StockDetail> details){
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				details.forEach(detail -> {
					if(detail != null){
						String ticker = detail.getTicker();
						if(stockDetailCache.get(ticker) != null && 
								!stockDetailCache.get(ticker).equals(detail)){
							
							repository.insert((Domain) stockDetailCache.get(ticker));	
							websocketImpl.sendStock(detail);							
						}
						stockDetailCache.put(ticker, detail);
					}
				});
			}	
		});
		t.start();
		return t;
	}

}
