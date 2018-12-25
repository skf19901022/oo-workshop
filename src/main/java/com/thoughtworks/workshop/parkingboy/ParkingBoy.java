package com.thoughtworks.workshop.parkingboy;

import com.thoughtworks.workshop.parkinglot.Car;
import com.thoughtworks.workshop.parkinglot.ParkingLot;
import com.thoughtworks.workshop.parkinglot.Ticket;
import com.thoughtworks.workshop.parkinglot.exception.InvalidTicketException;
import com.thoughtworks.workshop.parkinglot.exception.ParkingLotIsFullException;
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
    throw new ParkingLotIsFullException();
  }

  public void manage(ParkingLot parkingLot) {
    parkingLots.add(parkingLot);
  }

  public Car pick(Ticket ticket) {
    for (ParkingLot parkingLot: parkingLots){
      if( parkingLot.searchCarByTicket(ticket)){
        return parkingLot.pick(ticket);
      }
    }
    throw new InvalidTicketException();
  }
}
