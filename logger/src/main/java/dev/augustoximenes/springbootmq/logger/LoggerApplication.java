package dev.augustoximenes.springbootmq.logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@SpringBootApplication
@Slf4j
@EnableJms
public class LoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggerApplication.class, args);
	}

	@JmsListener(destination = "dev/")
	public void onMessage(Message message) throws JMSException {
		TextMessage textMessage = (TextMessage) message;
		String textMessageBody = textMessage.getText();
		log.info("[Message] " + textMessageBody);
	}

}
