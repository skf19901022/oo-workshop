package com.thoughtworks.workshop.parkinglot;

import com.thoughtworks.workshop.parkingboy.ParkingBoy;
import com.thoughtworks.workshop.parkinglot.exception.InvalidTicketException;
import com.thoughtworks.workshop.parkinglot.exception.ParkingLotIsFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingBoyTest {

  @Test
  void shouldReturnTicketWhenParkingBoyParkGivenParkingLotIsAvailable() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy();
    parkingBoy.manage(parkingLot);
    Car car = new Car();

    assertNotNull(parkingBoy.park(car));
  }

  @Test
  void shouldReturnTicketWhenParkingBoyParkGivenParkingLotNumber1IsFullAndNumber2IsAvailable() {
    ParkingLot parkingLotNumber1 = new ParkingLot(1);
    ParkingLot parkingLotNumber2 = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy();
    parkingBoy.manage(parkingLotNumber1);
    parkingBoy.manage(parkingLotNumber2);

    Car toyota = new Car();
    assertNotNull(parkingBoy.park(toyota));

    Car porsche = new Car();
    assertNotNull(parkingBoy.park(porsche));
  }

  @Test
  void shouldThrowParkingFailedExceptionWhenParkingBoyParkTwoCarsGivenThereIsOnlyOnePlace() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy();
    parkingBoy.manage(parkingLot);

    Car toyota = new Car();
    assertNotNull(parkingBoy.park(toyota));

    Car porsche = new Car();
    assertThrows(ParkingLotIsFullException.class, () -> parkingBoy.park(porsche));
  }

  @Test
  void shouldReturnCarWhenPickCarGivenValidTicketToParkingBoy() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy();
    parkingBoy.manage(parkingLot);

    Car toyota = new Car();
    Ticket ticket = parkingBoy.park(toyota);

    assertSame(toyota, parkingBoy.pick(ticket));
  }

  @Test
  void shouldThrowPickFailedExceptionWhenPickCarGivenInvalidTicketToParkingBoy() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy();
    parkingBoy.manage(parkingLot);

    assertThrows(InvalidTicketException.class, () -> parkingBoy.pick(new Ticket()));
  }

  @Test
  void shouldReturnTicketWhenParkCarGivenLotIsFullAndPickACarAndParkCar() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy();
    parkingBoy.manage(parkingLot);

    Car toyota = new Car();
    Ticket ticket = parkingBoy.park(toyota);
    assertSame(toyota, parkingBoy.pick(ticket));

    assertNotNull(parkingBoy.park(toyota));
  }
}
