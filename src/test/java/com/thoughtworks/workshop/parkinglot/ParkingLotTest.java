package com.thoughtworks.workshop.parkinglot;


import com.thoughtworks.workshop.parkinglot.exception.InvalidTicketException;
import com.thoughtworks.workshop.parkinglot.exception.ParkingLotIsFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

  @Test
  void shouldReturnTicketWhenParkingCarGivenParkingLotHaveAvailableSeat() {
    Car car = new Car();
    ParkingLot parkingLot = new ParkingLot(1);

    assertNotNull(parkingLot.pack(car));
  }

  @Test
  void shouldReturnExceptionWhenParkingCarGivenParkingLotIsFull() {
    Car car = new Car();
    ParkingLot parkingLot = new ParkingLot(1);
    parkingLot.pack(car);

    assertThrows(ParkingLotIsFullException.class, () -> parkingLot.pack(new Car()));
  }

  @Test
  void shouldReturnCarWhenGetCarGivenParingLotTicketAndOnlyMyCarInTheLot() {
    Car car = new Car();
    ParkingLot parkingLot = new ParkingLot(1);

    Ticket ticket = parkingLot.pack(car);
    assertEquals(car, parkingLot.pick(ticket));
  }

  @Test
  void shouldReturnCarWhenGetCarGivenParingLotTicketAndThereAreOtherCarsInTheLot() {
    Car myCar = new Car();
    Car someOnesCar = new Car();
    ParkingLot parkingLot = new ParkingLot(2);

    Ticket ticket = parkingLot.pack(myCar);
    Ticket ticket2 = parkingLot.pack(someOnesCar);
    assertEquals(myCar, parkingLot.pick(ticket));
    assertEquals(someOnesCar, parkingLot.pick(ticket2));
  }

  @Test
  void shouldReturnExceptionWhenGetCarGivenInvalidParingLotTicket() {
    Car car = new Car();
    ParkingLot parkingLot = new ParkingLot(2);

    Ticket ticket = parkingLot.pack(car);
    parkingLot.pick(ticket);

    assertThrows(InvalidTicketException.class, () -> parkingLot.pick(ticket));
  }

  @Test
  void shouldReturnTicketWhenParkingCarGivenParkingLotIsFullAndSomeOneGetCar() {
    Car car = new Car();
    ParkingLot parkingLot = new ParkingLot(1);

    Ticket ticket = parkingLot.pack(car);
    parkingLot.pick(ticket);

    assertNotNull(parkingLot.pack(car));
  }
}
