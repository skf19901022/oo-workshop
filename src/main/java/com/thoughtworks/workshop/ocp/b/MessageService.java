package com.thoughtworks.workshop.ocp.b;

public class MessageService {
  private EmailMessage emailMessage;
  private PhoneMessage phoneMessage;
  private MessageType messageType;

  public MessageService(MessageType type) {
    this.messageType = type;
    if (type == MessageType.EMAIL) {
      emailMessage = new EmailMessage();
    } else if (type == MessageType.PHONE) {
      phoneMessage = new PhoneMessage();
    }
  }

  public void Greeting(String message) {
    if (this.messageType == MessageType.EMAIL) {
      emailMessage.sendMessage(message);
    } else if (this.messageType == MessageType.PHONE) {
      phoneMessage.sendMessage(message);
    }
  }
}
