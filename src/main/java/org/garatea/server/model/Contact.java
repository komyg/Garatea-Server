package org.garatea.server.model;

/**
 * This class represents the contact information that is sent from the frontend.
 * It will be used to send an e-mail.
 * @author Felipe
 *
 */
public class Contact implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private String senderEmail;
	private String senderName;
	private String subject;
	private String message;
	private ContactType type;
	
	public Contact() {
		
	}
	
	public Contact(String senderEmail, String senderName, String subject, String message, ContactType type) {
		this.senderEmail = senderEmail;
		this.senderName = senderName;
		this.subject = subject;
		this.message = message;
		this.type = type;
	}

	public String getSenderEmail() {
		return senderEmail;
	}
	
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	
	public String getSenderName() {
		return senderName;
	}
	
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ContactType getType() {
		return type;
	}
	
	public void setType(ContactType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "ContactModel [senderEmail=" + senderEmail + ", senderName=" + senderName + ", subject=" + subject
				+ ", message=" + message + ", type=" + type + "]";
	}
}
