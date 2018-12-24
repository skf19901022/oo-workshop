package com.thoughtworks.workshop.parkinglot;


import com.thoughtworks.workshop.parkinglot.exception.ParkingException;
import com.thoughtworks.workshop.parkinglot.exception.TicketException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

  @Test
  void shouldReturnTicketWhenParkingCarGivenParkingLotHaveAvailableSeat() {
    Car car = new Car("1");
    ParkingLot parkingLot = new ParkingLot(1);

    assertEquals("1", parkingLot.parking(car).getCarInfo());
  }

  @Test
  void shouldReturnExceptionWhenParkingCarGivenParkingLotIsFull() {
    Car car = new Car("1");
    ParkingLot parkingLot = new ParkingLot(0);

    assertThrows(ParkingException.class, () -> parkingLot.parking(car));
  }

  @Test
  void shouldReturnCarWhenGetCarGivenParingLotTicketAndOnlyMyCarInTheLot() {
    Car car = new Car("1");
    ParkingLot parkingLot = new ParkingLot(1);

    Ticket ticket = parkingLot.parking(car);
    assertEquals(car, parkingLot.getCar(ticket));
  }

  @Test
  void shouldReturnCarWhenGetCarGivenParingLotTicketAndThereAreOtherCarsInTheLot() {
    Car car = new Car("1");
    Car car2 = new Car("2");
    ParkingLot parkingLot = new ParkingLot(2);

    Ticket ticket = parkingLot.parking(car);
    Ticket ticket2 = parkingLot.parking(car2);
    assertEquals(car, parkingLot.getCar(ticket));
    assertEquals(car2, parkingLot.getCar(ticket2));
  }

  @Test
  void shouldReturnExceptionWhenGetCarGivenInvalidParingLotTicket() {
    Car car = new Car("1");
    ParkingLot parkingLot = new ParkingLot(2);

    Ticket ticket = parkingLot.parking(car);
    parkingLot.getCar(ticket);

    assertThrows(TicketException.class, () -> parkingLot.getCar(ticket));
  }

  @Test
  void shouldReturnTicketWhenParkingCarGivenParkingLotIsFullAndSomeOneGetCar() {
    Car car = new Car("1");
    ParkingLot parkingLot = new ParkingLot(1);

    Ticket ticket = parkingLot.parking(car);
    parkingLot.getCar(ticket);

    assertEquals("1", parkingLot.parking(car).getCarInfo());
  }
}
