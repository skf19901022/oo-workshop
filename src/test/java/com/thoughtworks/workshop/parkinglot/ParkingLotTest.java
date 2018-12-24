package com.thoughtworks.workshop.parkinglot;


import com.thoughtworks.workshop.parkinglot.exception.ParkingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

}
