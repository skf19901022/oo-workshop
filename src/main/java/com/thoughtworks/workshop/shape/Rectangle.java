package com.thoughtworks.workshop.shape;

public class Rectangle implements Shape {
  private int width;
  private int length;

  public Rectangle(int width, int length) {
    this.width = width;
    this.length = length;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  @Override
  public int calculateArea() {
    return this.width * this.length;
  }

  @Override
  public void increaseWidth() {
    if (this.length > this.width) {
      this.width = this.width + 1;
    }
  }
}
