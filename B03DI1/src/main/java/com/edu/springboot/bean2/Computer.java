package com.edu.springboot.bean2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("macbook")
public class Computer {
	
	@Value("M1")
	private String cpu;

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	@Override
	public String toString() {
		return "Notebook [cpu="+cpu+"]";
	}
	
}
