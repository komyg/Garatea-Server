package org.garatea.server.service;

import org.garatea.server.model.Contact;

public interface EmailService {
	
	void sendMessage(Contact data);

}
