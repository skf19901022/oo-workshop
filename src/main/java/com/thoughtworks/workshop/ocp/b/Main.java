package com.thoughtworks.workshop.ocp.b;

public class Main {
  public static void main(String[] args) {
    String message = "保暖队";

    MessageService emailMessageService = new MessageService(MessageType.EMAIL);
    emailMessageService.Greeting(message);

    MessageService phoneMessageService = new MessageService(MessageType.PHONE);
    phoneMessageService.Greeting(message);
  }
}
