package com.thoughtworks.workshop.ocp.well;

public class MessageService {
  private Sendable sendable;

  public MessageService(Sendable sendable) {
    this.sendable = sendable;
  }

  public void Greeting(String message) {
    sendable.sendMessage(message);
  }
}
