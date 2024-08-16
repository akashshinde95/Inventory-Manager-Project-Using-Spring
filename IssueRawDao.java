package com.akash.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.akash.RawMaterial.IssueProMat;
import com.akash.RawMaterial.IssueRawMat;
import com.akash.RawMaterial.RawMaterial;

@Component
public class IssueRawDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public IssueRawDao(HibernateTemplate hibernateTemplate, RawMaterial rawMaterial, RawDao rawDao) {
		super();
		this.hibernateTemplate = hibernateTemplate;
		this.rawMaterial = rawMaterial;
		this.rawDao = rawDao;
	}

	@Override
	public String toString() {
		return "IssueRawDao [hibernateTemplate=" + hibernateTemplate + ", rawMaterial=" + rawMaterial + ", rawDao="
				+ rawDao + "]";
	}

	public IssueRawDao() {
		super();
		// TODO Auto-generated constructor stub
	}





	@Autowired
	private RawMaterial rawMaterial;
	@Autowired
	private RawDao rawDao;
	
	
	@Transactional
	public int addIssueRawMat(IssueRawMat issueRawMat){
		int i=(Integer)hibernateTemplate.save(issueRawMat);
		return i;
	}
	
	
	/*
	public IssueRawMat getIssueRawMat(int iId){
		IssueRawMat issueRawMat = hibernateTemplate.get(IssueRawMat.class, iId);
		return issueRawMat;
	}
	*/
	
	public List<IssueRawMat>getAllIssueRawMat()
	{
		List<IssueRawMat>issueRawMate = hibernateTemplate.loadAll(IssueRawMat.class);
		return issueRawMate;
	}
	
	
	public List<IssueRawMat>issueRawMat()
	{
		List<IssueRawMat>issueRawMats = hibernateTemplate.loadAll(IssueRawMat.class);
		return issueRawMats;
	}
	
	@Transactional
	public void deleteIssueRawMat(int iId) 
	{
		IssueRawMat issueRawMat = hibernateTemplate.get(IssueRawMat.class, iId);
		hibernateTemplate.delete(issueRawMat);
	}
	
	
	/*@Transactional 
	public void updateIssueRawMat(IssueRawMat issueRawMat) 
	{
		hibernateTemplate.update(issueRawMat);
	}*/
	
}
