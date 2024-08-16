package com.akash.RawMaterial;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class IssueRawMat {
	
	@Id
	private int iId;
	private int rawId;
	private String iRawName;
	private String iRawUserName;
	private float iRawquantity;
	private String iRawDate, iRawTime;
	
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public int getRawId() {
		return rawId;
	}
	public void setRawId(int rawId) {
		this.rawId = rawId;
	}
	public String getiRawName() {
		return iRawName;
	}
	public void setiRawName(String iRawName) {
		this.iRawName = iRawName;
	}
	public String getiRawUserName() {
		return iRawUserName;
	}
	public void setiRawUserName(String iRawUserName) {
		this.iRawUserName = iRawUserName;
	}
	public float getiRawquantity() {
		return iRawquantity;
	}
	public void setiRawquantity(float iRawquantity) {
		this.iRawquantity = iRawquantity;
	}
	public String getiRawDate() {
		return iRawDate;
	}
	public void setiRawDate(String iRawDate) {
		this.iRawDate = iRawDate;
	}
	public String getiRawTime() {
		return iRawTime;
	}
	public void setiRawTime(String iRawTime) {
		this.iRawTime = iRawTime;
	}
	public IssueRawMat(int iId, int rawId, String iRawName, String iRawUserName, float iRawquantity, String iRawDate,
			String iRawTime) {
		super();
		this.iId = iId;
		this.rawId = rawId;
		this.iRawName = iRawName;
		this.iRawUserName = iRawUserName;
		this.iRawquantity = iRawquantity;
		this.iRawDate = iRawDate;
		this.iRawTime = iRawTime;
	}
	public IssueRawMat() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "IssueRawMat [iId=" + iId + ", rawId=" + rawId + ", iRawName=" + iRawName + ", iRawUserName="
				+ iRawUserName + ", iRawquantity=" + iRawquantity + ", iRawDate=" + iRawDate + ", iRawTime=" + iRawTime
				+ "]";
	}

}
