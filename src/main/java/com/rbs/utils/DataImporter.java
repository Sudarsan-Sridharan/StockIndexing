package com.rbs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.rbs.domains.Stock;

@Component
public class DataImporter {

	public List<Stock> readExcel(String filename){
		List<Stock> stockList = new ArrayList();
		File excelFile = new File(this.getClass().getClassLoader().getResource(filename).getFile());
		try {
			FileInputStream fileInputStream = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			boolean firstRow = true;
			while(rowIterator.hasNext()){
				Row currentRow = rowIterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				if(firstRow){
					firstRow = !firstRow;
					continue;
				}
				
				Stock stock = rowToStock(currentRow);
				stockList.add(stock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockList;
	}
	
	private Stock rowToStock(Row row){
		Stock stock = new Stock(row.getCell(0).getStringCellValue(),
				row.getCell(1).getStringCellValue(),
				row.getCell(2).getNumericCellValue(),
				row.getCell(3).getStringCellValue(),
				row.getCell(4).getStringCellValue(), 
				new Timestamp(System.currentTimeMillis()));
		
		return stock;
	}
}
