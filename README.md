# Garatéa Server

This is the backend of the Garatéa initiative website. It was designed as a RESTful web service to handle the requests from the frontend.

# What is it

Garatéa, or lifeguard in Tupi-guarani, is a network formation initiative that aims at increasing the survival rate of medical emergencies creating teams of first responders inside the civilian communities, so that they can aid in the emergency care while the victims wait for the arrival of the paramedics. We value universality, cooperation and living together in communities.

# Services

## Email service

This service receives contact data from the frontend contact form and sends an e-mail based on this data.

### Accessing

The email service can be accessed via HTTP POST through the following path: `/email`.

### Input data

This service consumes data as `application/json` with the following properties:
 
* **senderMail:** e-mail from the person that is sending the contact request.
* **senderName:** name of the person that is sending the contact request.
* **subject:** subject of the e-mail.
* **message:** the contents of the e-mail.
* **type:** integer containing the message type. Each type will route the message to a different recipient e-mail. Each type is described below:
	0: Generic all purpose message.
	1: Partner type message.
	2: Volunteer type message.
	3: Hub type message.

Below is an example of the JSON.

```
{
  "senderMail": "test@email.com",
  "senderName": "John Doe",
  "subject": "Test",
  "message": "This is a test!",
  "type": 1
}
```

### Returns

The email service does not return any data. If the operation was successful *HTTP 200* is returned, otherwise *HTTP 500* is returned. 
