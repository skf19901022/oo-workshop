package com.thoughtworks.workshop.parkingboy;

import com.thoughtworks.workshop.parkinglot.Car;
import com.thoughtworks.workshop.parkinglot.ParkingLot;
import com.thoughtworks.workshop.parkinglot.Ticket;
import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

  private List<ParkingLot> parkingLots;

  public ParkingBoy() {
    parkingLots = new ArrayList<>();
  }

  public Ticket park(Car car) {
    for (ParkingLot parkingLot : parkingLots) {
      if (parkingLot.isNotFull()) {
        return parkingLot.park(car);
      }
    }
    return null;
  }

  public void manage(ParkingLot parkingLot) {
    parkingLots.add(parkingLot);
  }
}
