package com.thoughtworks.workshop.ocp.a;

public class MessageService {
  private EmailMessage emailMessage;

  public MessageService() {
    this.emailMessage = new EmailMessage();
  }

  public void Greeting(String message) {
    emailMessage.sendMessage(message);
  }
}
