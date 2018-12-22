package com.thoughtworks.workshop.shape;

public class Square implements Shape {
  private int width;
  private int length;

  public Square(int width) {
    this.width = width;
    this.length = width;
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
    return this.width * this.width;
  }

  @Override
  public void increaseWidth() {
    if (this.length > this.width) {
      this.width = this.width + 1;
    }
  }
}
