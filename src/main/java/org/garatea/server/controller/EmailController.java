package org.garatea.server.controller;

import org.garatea.server.model.Contact;
import org.garatea.server.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {
	
	private final static Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/email", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void sendEmail(@RequestBody Contact contactData) {
		logger.info(contactData.toString());
		emailService.sendMessage(contactData);
	}

}
