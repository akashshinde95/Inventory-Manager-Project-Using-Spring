package com.akash.Dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.akash.RawMaterial.RawMaterial;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.List;


@Component
public class RawDao {
	
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
		return "RawDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	public RawDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RawDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	
	
	@Transactional
	public int addRawMaterial(RawMaterial rawMaterial){
		int i = (Integer) hibernateTemplate.save(rawMaterial);
		return i;
	}

	public RawMaterial getRawMaterial(int rawId){
		RawMaterial rawMaterial = hibernateTemplate.get(RawMaterial.class, rawId);
		return rawMaterial;
	}
	
	public List<RawMaterial>getAllRawMaterial()
	{
		List<RawMaterial>rawMaterials = hibernateTemplate.loadAll(RawMaterial.class);
		return rawMaterials;
	}
	
	@Transactional
	public void deleteRawMaterial(int rawId) 
	{
		RawMaterial rawMaterial = hibernateTemplate.get(RawMaterial.class, rawId);
		hibernateTemplate.delete(rawMaterial);
	}
	
	@Transactional
	public void updateRaw(int rawId, int addrawQuantity) 
	{
		RawMaterial rawMaterial = hibernateTemplate.get(RawMaterial.class, rawId);
		if(rawMaterial != null)
		{
			 int currentQuantity = rawMaterial.getRawQuantity();
		     rawMaterial.setRawQuantity(currentQuantity + addrawQuantity);  // Keep as int
		     hibernateTemplate.update(rawMaterial);
		}
		else
		{
			System.err.println("Not Found");
		}
		
	}    
	
	
	@Transactional
	public void updateRawMaterial(RawMaterial rawMaterial) {
	    hibernateTemplate.update(rawMaterial);
	}
	
	
	@Transactional
	public List<RawMaterial> getAllUnavailableRawMaterials() {
	    List<RawMaterial> rawMaterials = (List<RawMaterial>) hibernateTemplate.find("from RawMaterial where rawQuantity = 0");
	    return rawMaterials;
	}


}


