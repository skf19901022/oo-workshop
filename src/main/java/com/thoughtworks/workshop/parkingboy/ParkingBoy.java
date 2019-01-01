package com.thoughtworks.workshop.parkingboy;

import com.thoughtworks.workshop.parkinglot.Car;
import com.thoughtworks.workshop.parkinglot.ParkingLot;
import com.thoughtworks.workshop.parkinglot.Ticket;
import com.thoughtworks.workshop.parkinglot.exception.ParkingLotIsFullException;

public class ParkingBoy extends BasicBoy {

  public Ticket park(Car car) {
    for (ParkingLot parkingLot : parkingLots) {
      if (parkingLot.isNotFull()) {
        return parkingLot.park(car);
      }
    }
    throw new ParkingLotIsFullException();
  }

}
