package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Home {
   // pojo class
	
	// constructor
	Home(){
		System.out.println("Home sweet home");
	}
	private String ownerName;
	private int doorNo;
	
	@Autowired
	@Qualifier("abc")
	private InternetSpeed modem;
	
	
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public void connect() {
		modem.switchOnTheinternet();
		System.out.println("connected to internet");
	}
}
