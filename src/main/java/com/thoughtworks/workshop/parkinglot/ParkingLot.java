package com.thoughtworks.workshop.parkinglot;

public class ParkingLot {

  private int availableSeatCount;

  public ParkingLot(int seatCount) {
    this.availableSeatCount = seatCount;
  }

  public Ticket parking(Car car) {
    if (availableSeatCount == 0) {
      return null;
    }
    availableSeatCount--;
    return new Ticket(car.getInfo());
  }


}
