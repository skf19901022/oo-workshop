package com.thoughtworks.workshop.comparelength;

public class KMLength implements Comparable {

  private double length;

  public KMLength(int length) {
    this.length = length;
  }

  @Override
  public int compare(Comparable a) {
    return Double.compare(this.getLength() , a.getLength());
  }

  @Override
  public double getLength() {
    return length* 1000;
  }
}
