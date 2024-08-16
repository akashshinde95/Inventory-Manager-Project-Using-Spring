package com.akash.RawMaterial;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class ProcessMaterial {
	
	@Id
	private int ProMatId;
	private String ProMatName;
	private int ProMatQuantity;
	private String ProMatUnit;
	private float ProMatCostPerUnit;
	
	public int getProMatId() {
		return ProMatId;
	}
	public void setProMatId(int proMatId) {
		ProMatId = proMatId;
	}
	public String getProMatName() {
		return ProMatName;
	}
	public void setProMatName(String proMatName) {
		ProMatName = proMatName;
	}
	public int getProMatQuantity() {
		return ProMatQuantity;
	}
	public void setProMatQuantity(int proMatQuantity) {
		ProMatQuantity = proMatQuantity;
	}
	public String getProMatUnit() {
		return ProMatUnit;
	}
	public void setProMatUnit(String proMatUnit) {
		ProMatUnit = proMatUnit;
	}
	public float getProMatCostPerUnit() {
		return ProMatCostPerUnit;
	}
	public void setProMatCostPerUnit(float proMatCostPerUnit) {
		ProMatCostPerUnit = proMatCostPerUnit;
	}
	public ProcessMaterial(int proMatId, String proMatName, int proMatQuantity, String proMatUnit,
			float proMatCostPerUnit) {
		super();
		ProMatId = proMatId;
		ProMatName = proMatName;
		ProMatQuantity = proMatQuantity;
		ProMatUnit = proMatUnit;
		ProMatCostPerUnit = proMatCostPerUnit;
	}
	public ProcessMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProcessMaterial [ProMatId=" + ProMatId + ", ProMatName=" + ProMatName + ", ProMatQuantity="
				+ ProMatQuantity + ", ProMatUnit=" + ProMatUnit + ", ProMatCostPerUnit=" + ProMatCostPerUnit + "]";
	}
	
}
