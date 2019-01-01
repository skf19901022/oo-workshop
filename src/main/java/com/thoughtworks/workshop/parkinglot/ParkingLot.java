package com.thoughtworks.workshop.parkinglot;

import com.thoughtworks.workshop.parkinglot.exception.InvalidTicketException;
import com.thoughtworks.workshop.parkinglot.exception.ParkingLotIsFullException;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

  private int totalSpace;

  private Map<Ticket, Car> parkedCars;

  public ParkingLot(int totalSpace) {
    this.totalSpace = totalSpace;
    parkedCars = new HashMap<>();
  }

  public Ticket park(Car car) {
    if (totalSpace <= parkedCars.size()) {
      throw new ParkingLotIsFullException();
    }
    Ticket ticket = new Ticket();
    parkedCars.put(ticket, car);
    return ticket;
  }

  public Car pick(Ticket ticket) {
    if (parkedCars.containsKey(ticket)) {
      return parkedCars.remove(ticket);
    }
    throw new InvalidTicketException();
  }

  public boolean isNotFull() {
    return totalSpace > parkedCars.size();
  }

  public boolean contains(Ticket ticket) {
    return parkedCars.containsKey(ticket);
  }

  public int availableSpace(){
    return totalSpace - parkedCars.size();
  }
}
