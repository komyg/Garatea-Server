package org.garatea.server.integration;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class EmailIntegrationTest {

	private String mockContactRequest;
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void sendGenericEmail() throws Exception {
		
		// Create JSON.
		StringBuilder str = new StringBuilder();
		str.append("{ ");
		str.append("\"senderEmail\": \"test@email.com\", ");
		str.append("\"senderName\": \"John Doe\", ");
		str.append("\"subject\": \"Generic Email Test\", ");
		str.append("\"message\": \"This is a test\", ");
		str.append("\"type\": 0 ");
		str.append("}");
		
		mockContactRequest = str.toString();
		
		mvc.perform(MockMvcRequestBuilders.post("/email").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(mockContactRequest))
		.andExpect(status().isOk());
	}
	
	@Test
	public void sendPartnerEmail() throws Exception {
		
		// Create JSON.
		StringBuilder str = new StringBuilder();
		str.append("{ ");
		str.append("\"senderEmail\": \"test@email.com\", ");
		str.append("\"senderName\": \"John Doe\", ");
		str.append("\"subject\": \"Partner Email Test\", ");
		str.append("\"message\": \"This is a test\", ");
		str.append("\"type\": 1 ");
		str.append("}");
		
		mockContactRequest = str.toString();
		
		mvc.perform(MockMvcRequestBuilders.post("/email").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(mockContactRequest))
		.andExpect(status().isOk());
	}
	
	@Test
	public void sendVolunteerEmail() throws Exception {
		
		// Create JSON.
		StringBuilder str = new StringBuilder();
		str.append("{ ");
		str.append("\"senderEmail\": \"test@email.com\", ");
		str.append("\"senderName\": \"John Doe\", ");
		str.append("\"subject\": \"Volunteer Email Test\", ");
		str.append("\"message\": \"This is a test\", ");
		str.append("\"type\": 2 ");
		str.append("}");
		
		mockContactRequest = str.toString();
		
		mvc.perform(MockMvcRequestBuilders.post("/email").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(mockContactRequest))
		.andExpect(status().isOk());
	}
	
	@Test
	public void sendHubEmail() throws Exception {
		
		// Create JSON.
		StringBuilder str = new StringBuilder();
		str.append("{ ");
		str.append("\"senderEmail\": \"test@email.com\", ");
		str.append("\"senderName\": \"John Doe\", ");
		str.append("\"subject\": \"Hub Email Test\", ");
		str.append("\"message\": \"This is a test\", ");
		str.append("\"type\": 3 ");
		str.append("}");
		
		mockContactRequest = str.toString();
		
		mvc.perform(MockMvcRequestBuilders.post("/email").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(mockContactRequest))
		.andExpect(status().isOk());
	}
}
