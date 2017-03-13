package com.rbs.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rbs.domains.Domain;
import com.rbs.domains.Stock;

@Repository
@Transactional
public class RepositoryImpl implements com.rbs.repository.Repository {

	private SessionFactory sessionFactory;
	
	@Autowired  
	public RepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Domain> findAll(String domain){
		return sessionFactory
					.getCurrentSession()
					.createQuery("from " + domain)
					.list();		
	}
	
	public boolean insert(Domain domain){
		return sessionFactory
					.getCurrentSession()
					.save(domain) != null;
	}

	public void insertAll(List<Stock> list){
		list.forEach(stock -> insert(stock));
	}

}
