package dev.augustoximenes.springbootmq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import java.util.Date;

@SpringBootApplication
@EnableJms
public class ProducerApplication {

	@Autowired
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@PostConstruct
	void send() throws JMSException, InterruptedException {
		while(true) {
			for(int i = 0; i < 10; i++) {
				System.out.println(i);
				jmsTemplate.convertAndSend("dev/", new Date().toString());
			}

			Thread.sleep(3000);
		}
	}
}
