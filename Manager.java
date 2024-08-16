package com.akash.RawMaterial;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Manager {
	
	@Id
	private String cemail;
	private String cpasword;
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCpasword() {
		return cpasword;
	}
	public void setCpasword(String cpasword) {
		this.cpasword = cpasword;
	}
	public Manager(String cemail, String cpasword) {
		super();
		this.cemail = cemail;
		this.cpasword = cpasword;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Manager [cemail=" + cemail + ", cpasword=" + cpasword + "]";
	}
	
}