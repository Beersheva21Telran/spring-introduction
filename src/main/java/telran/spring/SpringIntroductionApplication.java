package telran.spring;

import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIntroductionApplication {
static ConfigurableApplicationContext ctx;
	public static void main(String[] args) {
		ctx = SpringApplication.run(SpringIntroductionApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Enter exit for stopping application");
			String line = scanner.nextLine();
			if (line.equals("exit")) {
				
				break;
			}
		}
		
	}
	@PostConstruct
	void init() {
		System.out.println("Application context has been created");
	}
	@PreDestroy
	void preDestroy() {
		System.out.println("Bye");
	}

}
