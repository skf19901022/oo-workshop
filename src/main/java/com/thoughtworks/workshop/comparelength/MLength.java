package com.thoughtworks.workshop.comparelength;


public class MLength implements Comparable {

  private double length;
  public MLength(int length) {
    this.length = length;
  }

  @Override
  public int compare(Comparable a) {
    return Double.compare(this.getLength() * 1000, a.getLength());
  }

  @Override
  public double getLength() {
    return length;
  }
}
