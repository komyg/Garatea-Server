package org.garatea.server.controller;

import static org.mockito.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.garatea.server.model.Contact;
import org.garatea.server.service.EmailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmailControllerTest {
	
	@Autowired MockMvc mvc;
	
	@MockBean
	private EmailService emailService;
	
	private String mockContactRequest;
	
	@Before
	public void init() {
		
		// Create JSON.
		StringBuilder str = new StringBuilder();
		str.append("{ ");
		str.append("\"senderEmail\": \"test@email.com\", ");
		str.append("\"senderName\": \"John Doe\", ");
		str.append("\"subject\": \"Test\", ");
		str.append("\"message\": \"This is a test\", ");
		str.append("\"type\": 1 ");
		str.append("}");
		
		mockContactRequest = str.toString();
	}
	
	@Test
	public void shouldSendEmail() throws Exception {
		
		ArgumentCaptor<Contact> captor = ArgumentCaptor.forClass(Contact.class);
		
		mvc.perform(MockMvcRequestBuilders.post("/email").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(mockContactRequest))
			.andExpect(status().isOk());
		
		verify(emailService).sendMessage(captor.capture());
		assertEquals(captor.getValue().getSenderEmail(), "test@email.com");
	}
	
	@Test
	public void shouldFailSendingEmail() throws Exception {
		
		doThrow(new RuntimeException("Test exception")).when(emailService).sendMessage(any(Contact.class));
		
		mvc.perform(MockMvcRequestBuilders.post("/email").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(mockContactRequest))
		.andExpect(status().is5xxServerError());
	}
}
