package telran.spring.service.impl;

import org.springframework.stereotype.Service;

import telran.spring.service.SenderService;
@Service
public class SenderServiceSms implements SenderService {

	@Override
	public void send(String message) {
		System.out.println("sms message: " + message);
		

	}

}
