package com.thoughtworks.workshop.parkingboy;

import com.thoughtworks.workshop.parkinglot.Car;
import com.thoughtworks.workshop.parkinglot.ParkingLot;
import com.thoughtworks.workshop.parkinglot.Ticket;
import java.util.Comparator;

class SmartParkingBoy extends BasicBoy {

  Ticket park(Car car) {
    return this.parkingLots.stream().max(Comparator.comparing(ParkingLot::availableSpace))
        .map(lot -> lot.park(car)).orElse(null);
  }
}
