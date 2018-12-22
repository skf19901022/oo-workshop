package com.thoughtworks.workshop.ocp.well;

public class EmailMessage implements Sendable {
  @Override
  public void sendMessage(String message) {
    System.out.println("Email Hello:" + message);
  }
}
