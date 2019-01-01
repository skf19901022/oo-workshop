package com.thoughtworks.workshop.parkingboy;

import com.thoughtworks.workshop.parkinglot.Car;
import com.thoughtworks.workshop.parkinglot.ParkingLot;
import com.thoughtworks.workshop.parkinglot.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class SmartParkingBoyTest {

  @Test
  void shouldReturnParkInLot1WhenSmartBoyParkCarGivenParkingLot1HasMoreSpaceThanLot2() {
    ParkingLot parkingLot1 = new ParkingLot(2);
    ParkingLot parkingLot2 = new ParkingLot(1);

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
    smartParkingBoy.manage(parkingLot1);
    smartParkingBoy.manage(parkingLot2);

    Car car = new Car();
    Ticket ticket = smartParkingBoy.park(car);

    assertNotNull(ticket);

    assertSame(car, parkingLot1.pick(ticket));
  }

  @Test
  void shouldReturnParkInLot2WhenSmartBoyParkCarGivenParkingLot2HasMoreSpaceThanLot1() {
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(2);

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
    smartParkingBoy.manage(parkingLot1);
    smartParkingBoy.manage(parkingLot2);

    Car car = new Car();
    Ticket ticket = smartParkingBoy.park(car);

    assertNotNull(ticket);

    assertSame(car, parkingLot2.pick(ticket));
  }
}
