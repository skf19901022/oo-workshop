package com.thoughtworks.workshop.ocp.well;

public class PhoneMessage implements Sendable {
  @Override
  public void sendMessage(String message) {
    System.out.println("Phone Hello:" + message);
  }
}
