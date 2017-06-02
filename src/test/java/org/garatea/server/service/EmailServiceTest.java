package org.garatea.server.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.garatea.server.model.Contact;
import org.garatea.server.model.ContactType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"management.health.mail.enabled=false"})
public class EmailServiceTest {
	
	@MockBean
	private JavaMailSender mailSender;
	
	@Autowired
	private EmailService emailService;
	
	@Test
	public void shouldSendEmailMessage() {
		
		ArgumentCaptor<SimpleMailMessage> captor = ArgumentCaptor.forClass(SimpleMailMessage.class);
		Contact mockData = new Contact("john.doe@test.com", "John Doe", "This is a test", "Yes, really a test!", ContactType.GENERIC);
		
		emailService.sendMessage(mockData);
		verify(mailSender).send(captor.capture());
		assertEquals(captor.getValue().getSubject(), "This is a test");
	}

}
