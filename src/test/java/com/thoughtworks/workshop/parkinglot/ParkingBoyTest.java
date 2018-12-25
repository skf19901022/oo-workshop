package com.thoughtworks.workshop.parkinglot;

import com.thoughtworks.workshop.parkingboy.ParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {

  @Test
  void shouldReturnTicketWhenParkingBoyParkGivenParkingLotIsAvailable() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
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
}
