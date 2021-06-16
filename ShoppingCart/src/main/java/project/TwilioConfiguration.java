package project;

import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


@Service
public class TwilioConfiguration {

	public static final String ACCOUNT_SID = "AC02cfaac3068c69cf5dda4cbd3a8b2281";
    public static final String AUTH_TOKEN = "c819506315ea8e500c074b6f4e04b382";
	
	
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
