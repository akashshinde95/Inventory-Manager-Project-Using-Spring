package com.akash.Dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.akash.RawMaterial.ProcessMaterial;
import com.akash.RawMaterial.RawMaterial;

@Component
public class ProcessMateDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public String toString() {
		return "ProcessMateDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	public ProcessMateDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProcessMateDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	
	
	
	@Transactional
	public int addProcessMate(ProcessMaterial processMaterial){
		int i = (Integer) hibernateTemplate.save(processMaterial);
		return i;
	}

	public ProcessMaterial getProcessMaterial(int ProMatId){
		ProcessMaterial processMaterial = hibernateTemplate.get(ProcessMaterial.class, ProMatId);
		return processMaterial;
	}
	
	public List<ProcessMaterial>getAllProcessMaterial()
	{
		List<ProcessMaterial>processMaterials = hibernateTemplate.loadAll(ProcessMaterial.class);
		return processMaterials;
	}
	
	@Transactional
	public void deleteProcessMate(int ProMatId) 
	{
		ProcessMaterial processMaterial = hibernateTemplate.get(ProcessMaterial.class, ProMatId);
		hibernateTemplate.delete(processMaterial);
	}
	
	@Transactional
	public void updateproMaterial(int ProMatId, int addproQuantity) 
	{
		ProcessMaterial processMaterial = hibernateTemplate.get(ProcessMaterial.class, ProMatId);
		if(processMaterial != null)
		{
			 int currentQuantity = processMaterial.getProMatQuantity();
			 processMaterial.setProMatQuantity(currentQuantity + addproQuantity);
		     hibernateTemplate.update(processMaterial);
		}
		else
		{
			System.err.println("Not Found");
		}
		
	}    
	
	@Transactional
	public void updateProcessMaterial(ProcessMaterial processMaterial) {
	    hibernateTemplate.update(processMaterial);
	}
	
	@Transactional
	public List<ProcessMaterial> getAllUnavailableProMaterials() {
	    List<ProcessMaterial> processMaterials = (List<ProcessMaterial>) hibernateTemplate.find("from ProcessMaterial where ProMatQuantity = 0");
	    return processMaterials;
	}	
	
}
