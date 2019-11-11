package project.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class TwilioController {

	
	public static final String ACCOUNT_SID = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    public static final String AUTH_TOKEN = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	
	
	
	  public Message sendSMS() {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("+972542335127"),//The phone number you are sending text to
	                new com.twilio.type.PhoneNumber("+12056357868"),//The Twilio phone number
	                "You exceed from your balance, please settle your debt !!!!!")
	           .create();

	        return message;
	    }
	
	
	
	
	
}
