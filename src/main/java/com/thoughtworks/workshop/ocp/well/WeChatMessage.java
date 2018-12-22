package com.thoughtworks.workshop.ocp.well;

public class WeChatMessage implements Sendable {
  @Override
  public void sendMessage(String message) {
    System.out.println("WeChat Hello:" + message);
  }
}
