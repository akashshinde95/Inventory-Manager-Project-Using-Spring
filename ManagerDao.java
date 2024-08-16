package com.akash.Dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.akash.RawMaterial.Manager;

@Component
public class ManagerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public ManagerDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public ManagerDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ManagerDao [hibernateTemplate=" + hibernateTemplate + "]";
	}
	
	
	public Manager getInfo(String cemail) {
        return hibernateTemplate.get(Manager.class, cemail);
    }

    @Transactional
    public void updatePassword(Manager manager) {
        hibernateTemplate.update(manager);
    }
}
