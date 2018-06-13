package phillip.api.notification.domain;

import java.util.HashMap;

public class RequestData extends Notification{
	
	private String appType;
	
	public RequestData() {
		super();
	}

	public RequestData(String appType,String title, String message, HashMap<String, Object>  data) {
		super(title, message, data);
		this.appType = appType;
		
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	

}
