package com.rbs.repository;

import java.util.List;

import com.rbs.domains.Domain;
import com.rbs.domains.Stock;

public interface Repository {

	List<Domain> findAll(String domain);
	
	boolean insert(Domain domain);
	
	void insertAll(List<Stock> domain);
	
}
