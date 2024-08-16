package com.akash.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.akash.RawMaterial.*;

@Component
public class IssueProDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public IssueProDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public IssueProDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "IssueProDao [hibernateTemplate=" + hibernateTemplate + "]";
	}



	@Autowired
	private ProcessMaterial processMaterial;
	@Autowired
	private ProcessMateDao processMateDao;
	
	@Autowired
	private IssueProMat issueProMat;
	@Autowired
	private IssueProDao issueProDao;
	
	@Transactional
	public int addIssueProMat(IssueProMat issueProMat){
		int i=(Integer)hibernateTemplate.save(issueProMat);
		return i;
	}
	
	
	public List<IssueProMat> getAllIssueProMat() {
        return hibernateTemplate.loadAll(IssueProMat.class);
    }
	
	
	/*public List<IssueProMat>getAllIssueProMat()
	{
		List<IssueProMat>issueProMate = hibernateTemplate.loadAll(IssueProMat.class);
		return issueProMate;
	}
	
	
	public List<IssueProMat>issueProMat()
	{
		List<IssueProMat>issueProMats = hibernateTemplate.loadAll(IssueProMat.class);
		return issueProMats;
	}*/
	
	@Transactional
	public void deleteIssueProMat(int pId) 
	{
		IssueProMat issueProMat = hibernateTemplate.get(IssueProMat.class, pId);
		hibernateTemplate.delete(issueProMat);
	}  
	
}