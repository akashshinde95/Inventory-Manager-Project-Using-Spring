package com.akash.RawMaterial;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class RawMaterial 
{
	@Id
	private int rawId;
	private String rawName;
	private int rawQuantity;
	private String rawUnit;
	private float rawCostPerUnit;
	
	public int getRawId() {
		return rawId;
	}
	public void setRawId(int rawId) {
		this.rawId = rawId;
	}
	public String getRawName() {
		return rawName;
	}
	public void setRawName(String rawName) {
		this.rawName = rawName;
	}
	public int getRawQuantity() {
		return rawQuantity;
	}
	public void setRawQuantity(int rawQuantity) {
		this.rawQuantity = rawQuantity;
	}
	public String getRawUnit() {
		return rawUnit;
	}
	public void setRawUnit(String rawUnit) {
		this.rawUnit = rawUnit;
	}
	public float getRawCostPerUnit() {
		return rawCostPerUnit;
	}
	public void setRawCostPerUnit(float rawCostPerUnit) {
		this.rawCostPerUnit = rawCostPerUnit;
	}
	public RawMaterial(int rawId, String rawName, int rawQuantity, String rawUnit, float rawCostPerUnit) {
		super();
		this.rawId = rawId;
		this.rawName = rawName;
		this.rawQuantity = rawQuantity;
		this.rawUnit = rawUnit;
		this.rawCostPerUnit = rawCostPerUnit;
	}
	public RawMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RawMaterial [rawId=" + rawId + ", rawName=" + rawName + ", rawQuantity=" + rawQuantity + ", rawUnit="
				+ rawUnit + ", rawCostPerUnit=" + rawCostPerUnit + "]";
	}
	
}