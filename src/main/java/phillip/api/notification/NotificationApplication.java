package phillip.api.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import phillip.api.notification.domain.Notification;
import phillip.api.notification.producer.Sender;

@SpringBootApplication
public class NotificationApplication implements CommandLineRunner {

	@Autowired
	private Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sender:" + sender);
		sender.send("android", new Notification("Order Alert", "Notification message.", null));
		sender.send("ios", new Notification("Order Alert", "Notification 2.", null));
	}

}
