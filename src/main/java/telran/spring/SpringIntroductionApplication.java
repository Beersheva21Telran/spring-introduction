package telran.spring;

import java.util.Map;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import telran.spring.service.Sender;
import telran.spring.service.SenderService;

@SpringBootApplication
public class SpringIntroductionApplication {
static ConfigurableApplicationContext ctx;
	public static void main(String[] args) {
		ctx = SpringApplication.run(SpringIntroductionApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		Sender sender = ctx.getBean(Sender.class);
		Map<String, SenderService> senderServices = sender.getServices();
		System.out.println("Enter exit for stopping application");
		while(true) {
			System.out.println("Enter sender type");
			String line = scanner.nextLine();
			if (line.equals("exit")) {
				
				break;
			}
			
			
			SenderService service = senderServices.get(line);
			if (service == null) {
				System.out.printf("Service %s is not implemented yet\n", line);
				continue;
			}
			System.out.println("Enter message");
			line = scanner.nextLine();
			service.send(line);
			
			
		}
		
	}
	@PostConstruct
	void init() {
		System.out.println("Application context has been created " );
	}
	@PreDestroy
	void preDestroy() {
		System.out.println("Bye");
	}

}
