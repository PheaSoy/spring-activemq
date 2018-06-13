package phillip.api.notification.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import phillip.api.notification.domain.Notification;

@Component
public class ReceiverAndroid {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverAndroid.class);

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  @JmsListener(destination = "${queue.android}")
  public void receive(Notification notification) {
    LOGGER.info("received data in  android='{}'", notification);
    latch.countDown();
  }
}
