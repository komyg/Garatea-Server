package org.garatea.server.service;

import org.garatea.server.model.Contact;
import org.garatea.server.model.ContactType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	
	private final static Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Value("${garatea.mail.default}")
	private String defaultEmailRecipient;
	
	@Value("${garatea.mail.partner}")
	private String partnerEmailRecipient;
	
	@Value("${garatea.mail.volunteer}")
	private String volunteerEmailRecipient;
	
	@Value("${garatea.mail.hub}")
	private String hubEmailRecipient;
	
	@Override
	public void sendMessage(Contact data) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		StringBuilder messageText = new StringBuilder();
		String recipient = getEmailRecipient(data.getType());
		
		logger.info("Sending message to: " + recipient);
		
		// Format message content.
		messageText.append("Nome: " + data.getSenderName() + "\n");
		messageText.append("Email: " + data.getSenderEmail() + "\n");
		//messageText.append("Tipo: " + data.getType() + "\n");
		messageText.append("\n");
		messageText.append(data.getMessage());
		messageText.append("\n\n");
		messageText.append("Enviado por: Garatea Server Backend.");
		
		logger.debug("Message: " + messageText.toString());
		
		// Send message.
		message.setTo(recipient);
		message.setSubject(data.getSubject());
		message.setText(messageText.toString());
		emailSender.send(message);
		
		logger.info("Message successfully sent to: " + recipient);
	}
	
	/**
	 * Returns the message recipient based on the message type.
	 * The recipients are available in application.properties.
	 * @param type
	 * @return
	 */
	private String getEmailRecipient(ContactType type) {
		
		switch(type) {
			case GENERIC:
				return defaultEmailRecipient;
				
			case PARTNER:
				return partnerEmailRecipient;
				
			case VOLUNTEER:
				return volunteerEmailRecipient;
				
			case HUB:
				return hubEmailRecipient;
				
			default:
				return defaultEmailRecipient;	
		}
	}

}
