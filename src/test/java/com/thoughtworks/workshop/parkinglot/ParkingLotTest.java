package com.thoughtworks.workshop.parkinglot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingLotTest {

  @Test
  void shouldReturnTrueWhenParkingCarGivenParkingLotHaveAvailableSeat() {
    Car car = new Car("1");
    ParkingLot parkingLot = new ParkingLot(1);

    assertNotNull(parkingLot.parking(car));

  }
}
