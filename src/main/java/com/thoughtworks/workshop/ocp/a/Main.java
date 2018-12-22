package com.thoughtworks.workshop.ocp.a;

public class Main {
  public static void main(String[] args) {
    String message = "保暖队";

    MessageService emailMessageService = new MessageService();
    emailMessageService.Greeting(message);
  }
}
