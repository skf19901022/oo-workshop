package com.thoughtworks.workshop.parkingboy;

import com.thoughtworks.workshop.parkinglot.Car;
import com.thoughtworks.workshop.parkinglot.ParkingLot;
import com.thoughtworks.workshop.parkinglot.Ticket;

public class ParkingBoy {

  private ParkingLot parkingLot;

  public ParkingBoy(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }

  public Ticket park(Car car) {
    return parkingLot.park(car);
  }
}
