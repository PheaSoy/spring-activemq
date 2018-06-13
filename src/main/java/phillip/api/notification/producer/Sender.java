package phillip.api.notification.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

  @Autowired
  private JmsTemplate jmsTemplate;

  public void send(String destination, phillip.api.notification.domain.Notification notification) {
    LOGGER.info("sending message='{}' to destination='{}'", notification, destination);
    jmsTemplate.convertAndSend(destination, notification);
  }
}
