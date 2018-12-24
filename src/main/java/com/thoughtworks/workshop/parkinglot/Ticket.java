package com.thoughtworks.workshop.parkinglot;

public class Ticket {

  private String carInfo;

  public Ticket(String carInfo) {
    this.carInfo = carInfo;
  }

  public String getCarInfo() {
    return carInfo;
  }

  public void setCarInfo(String carInfo) {
    this.carInfo = carInfo;
  }
}
