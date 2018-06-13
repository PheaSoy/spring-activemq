package phillip.api.notification.domain;

import java.util.HashMap;

public class Notification {
	
	private String title;
	private String message;
	private HashMap<String, Object> data;
	public Notification() {
		
	}
	public Notification(String title, String message, HashMap<String, Object>  data) {
		super();
		this.title = title;
		this.message = message;
		this.data = data;
	}
	@Override
	public String toString() {
		return "Message [title=" + title + ", message=" + message + ", data=" + data + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HashMap<String, Object>  getData() {
		return data;
	}
	public void setData(HashMap<String, Object>  data) {
		this.data = data;
	}

}
