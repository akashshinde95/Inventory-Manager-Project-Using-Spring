package com.akash.RawMaterial;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class IssueProMat {
	
	@Id
	private int pId;
	private int pProId;
	private String pProName;
	private String pProUserName;
	private float pProquantity;
	private String pProDate, pProTime;
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getpProId() {
		return pProId;
	}
	public void setpProId(int pProId) {
		this.pProId = pProId;
	}
	public String getpProName() {
		return pProName;
	}
	public void setpProName(String pProName) {
		this.pProName = pProName;
	}
	public String getpProUserName() {
		return pProUserName;
	}
	public void setpProUserName(String pProUserName) {
		this.pProUserName = pProUserName;
	}
	public float getpProquantity() {
		return pProquantity;
	}
	public void setpProquantity(float pProquantity) {
		this.pProquantity = pProquantity;
	}
	public String getpProDate() {
		return pProDate;
	}
	public void setpProDate(String pProDate) {
		this.pProDate = pProDate;
	}
	public String getpProTime() {
		return pProTime;
	}
	public void setpProTime(String pProTime) {
		this.pProTime = pProTime;
	}
	public IssueProMat(int pId, int pProId, String pProName, String pProUserName, float pProquantity, String pProDate,
			String pProTime) {
		super();
		this.pId = pId;
		this.pProId = pProId;
		this.pProName = pProName;
		this.pProUserName = pProUserName;
		this.pProquantity = pProquantity;
		this.pProDate = pProDate;
		this.pProTime = pProTime;
	}
	public IssueProMat() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "IssueProMat [pId=" + pId + ", pProId=" + pProId + ", pProName=" + pProName + ", pProUserName="
				+ pProUserName + ", pProquantity=" + pProquantity + ", pProDate=" + pProDate + ", pProTime=" + pProTime
				+ "]";
	}

}
