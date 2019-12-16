package project;

import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


@Service
public class TwilioConfiguration {

	

	public static final String ACCOUNT_SID = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    public static final String AUTH_TOKEN = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	
	
	
	  public Message sendSMS() {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("+972542335127"),
	                new com.twilio.type.PhoneNumber("+12056357868"),
	                "You exceed from your balance, please settle your debt !!!!!")
	           .create();

	        return message;
	    }
	
	
	
	
	
}
