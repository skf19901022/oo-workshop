package com.thoughtworks.workshop.parkingboy;

import com.thoughtworks.workshop.parkinglot.Car;
import com.thoughtworks.workshop.parkinglot.ParkingLot;
import com.thoughtworks.workshop.parkinglot.Ticket;
import com.thoughtworks.workshop.parkinglot.exception.InvalidTicketException;
import java.util.ArrayList;
import java.util.List;

public abstract class BasicBoy {

  List<ParkingLot> parkingLots;

  abstract Ticket park(Car car);

  BasicBoy() {
    parkingLots = new ArrayList<>();
  }

  public void manage(ParkingLot parkingLot) {
    parkingLots.add(parkingLot);
  }

  public Car pick(Ticket ticket) {
    for (ParkingLot parkingLot : parkingLots) {
      if (parkingLot.contains(ticket)) {
        return parkingLot.pick(ticket);
      }
    }
    throw new InvalidTicketException();
  }
}
