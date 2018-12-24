package com.thoughtworks.workshop.parkinglot;

import com.thoughtworks.workshop.parkinglot.exception.ParkingException;
import com.thoughtworks.workshop.parkinglot.exception.TicketException;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

  private int availableSeatCount;

  Map<String, Car> parkedCars;

  public ParkingLot(int seatCount) {
    this.availableSeatCount = seatCount;
    parkedCars = new HashMap<>(seatCount);
  }

  public Ticket parking(Car car) {
    if (availableSeatCount == 0) {
      throw new ParkingException();
    }
    String carInfo = car.getInfo();
    parkedCars.put(carInfo, car);
    availableSeatCount--;
    return new Ticket(carInfo);
  }

  public Car getCar(Ticket ticket) {
    if (parkedCars.containsKey(ticket.getCarInfo())) {
      return parkedCars.remove(ticket.getCarInfo());
    }
    throw new TicketException();
  }
}
