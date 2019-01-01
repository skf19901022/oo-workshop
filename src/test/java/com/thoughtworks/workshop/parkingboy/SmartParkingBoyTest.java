package com.thoughtworks.workshop.parkingboy;

import com.thoughtworks.workshop.parkinglot.Car;
import com.thoughtworks.workshop.parkinglot.ParkingLot;
import com.thoughtworks.workshop.parkinglot.Ticket;
import com.thoughtworks.workshop.parkinglot.exception.InvalidTicketException;
import com.thoughtworks.workshop.parkinglot.exception.ParkingLotIsFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  @Test
  void shouldParkInLot1WhenSmartBoyParkCarGivenParkingLot1And2HasTheSameSpace() {
    ParkingLot parkingLot1 = new ParkingLot(1);
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
  void shouldThrowParkingLotExceptionWhenSmartBoyParkCarGivenParkingLot1And2IsFull() {
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(1);

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
    smartParkingBoy.manage(parkingLot1);
    smartParkingBoy.manage(parkingLot2);

    Car toyato = new Car();
    Car honda = new Car();
    smartParkingBoy.park(toyato);
    smartParkingBoy.park(honda);

    Car porsche = new Car();
    assertThrows(ParkingLotIsFullException.class, () -> smartParkingBoy.park(porsche));
  }

  @Test
  void shouldReturnCarWhenSmartBoyPickCarGivenAValidTicket() {
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(1);

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
    smartParkingBoy.manage(parkingLot1);
    smartParkingBoy.manage(parkingLot2);

    Car toyato = new Car();
    Ticket ticket = smartParkingBoy.park(toyato);

    assertSame(toyato, smartParkingBoy.pick(ticket));
  }

  @Test
  void shouldThrowTicketExceptionWhenSmartBoyPickCarGivenAInvalidTicket() {
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(1);

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
    smartParkingBoy.manage(parkingLot1);
    smartParkingBoy.manage(parkingLot2);

    assertThrows(InvalidTicketException.class, () -> smartParkingBoy.pick(new Ticket()));
  }
}
