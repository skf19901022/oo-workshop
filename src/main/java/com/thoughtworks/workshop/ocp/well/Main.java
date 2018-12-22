package com.thoughtworks.workshop.ocp.well;

public class Main {
  public static void main(String[] args) {
    String message = "保暖队";

    Sendable emailSender = new EmailMessage();
    MessageService emailMessageService = new MessageService(emailSender);
    emailMessageService.Greeting(message);

    Sendable phoneMessage = new PhoneMessage();
    MessageService phoneMessageService = new MessageService(phoneMessage);
    phoneMessageService.Greeting(message);

    Sendable weChatMessage = new WeChatMessage();
    MessageService weChatMessageService = new MessageService(weChatMessage);
    weChatMessageService.Greeting(message);
  }
}
