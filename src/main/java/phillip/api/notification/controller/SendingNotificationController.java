package phillip.api.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import phillip.api.notification.domain.RequestData;
import phillip.api.notification.producer.Sender;

@RequestMapping("/notification")
@RestController
public class SendingNotificationController {

	@Autowired

	private Sender sender;


	@PostMapping("/send")

	public ResponseEntity<?> sendNofication(@RequestBody RequestData data) {

	//	if (!NoficationConstants.appType.contains(data.getAppType()))
		//	return ResponseEntity.badRequest().body("App type invalid.");
		
		sender.send(data.getAppType(), new phillip.api.notification.domain.Notification(data.getTitle(), data.getMessage(), data.getData()));

		return ResponseEntity.ok("Sent notification success.");

	}

}
