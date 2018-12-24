package com.thoughtworks.workshop.parkinglot;

import com.thoughtworks.workshop.parkinglot.exception.ParkingException;

public class ParkingLot {

  private int availableSeatCount;

  public ParkingLot(int seatCount) {
    this.availableSeatCount = seatCount;
  }

  public Ticket parking(Car car) {
    if (availableSeatCount == 0) {
      throw new ParkingException();
    }
    availableSeatCount--;
    return new Ticket(car.getInfo());
  }


}
