package com.thoughtworks.workshop.comparelength;

public class MMLength implements Comparable {

  private double length;

  public MMLength(int length) {
    this.length = length;
  }

  @Override
  public int compare(Comparable a) {
    return Double.compare(this.getLength(), a.getLength());
  }

  public double getLength() {
    return length / 1000;
  }
}
