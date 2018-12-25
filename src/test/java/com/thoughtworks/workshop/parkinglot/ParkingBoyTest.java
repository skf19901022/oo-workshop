package com.thoughtworks.workshop.parkinglot;

import com.thoughtworks.workshop.parkingboy.ParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {

  @Test
  void shouldReturnTicketWhenParkingBoyParkGivenParkingLotIsAvailable() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
    Car car = new Car();

    assertNotNull(parkingBoy.park(car));
  }
}
