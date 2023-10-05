package com.example.demo;

import org.springframework.stereotype.Component;

@Component("abc")
public class InternetSpeed {
	private String ipAddress;
	private int speed;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;

	}
  public void switchOnTheinternet() {
	System.out.println("Internet was ready to connect");
}
}
