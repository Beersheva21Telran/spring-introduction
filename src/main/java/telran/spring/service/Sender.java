package telran.spring.service;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Sender {
	
	private final Map<String, SenderService> services;
	
	public Map<String, SenderService> getServices() {
		return services;
	}
	@Autowired
	public Sender(Map<String, SenderService> services) {
		this.services = services;
	}
	@PostConstruct
	void displayMap() {
		System.out.println(services);
	}
}
