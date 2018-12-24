package com.thoughtworks.workshop.comparelength;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthCompareTest {

  @Test
  public void shouldReturn1WhenCompareSameUnitLengthGivenSourceIsBiggerThanTarget() {
    Comparable kmLength = new KMLength(2);
    Comparable smallKmLength = new KMLength(1);

    assertEquals(1, kmLength.compare(smallKmLength));

    Comparable mLength = new MLength(2);
    Comparable smallMLength = new MLength(1);

    assertEquals(1, mLength.compare(smallMLength));


  }

  @Test
  public void shouldReturn1WhenCompareLengthGivenSourceIsBiggerThanTarget() {
    Comparable kmLength = new KMLength(1);
    Comparable mLength = new MLength(1);

    assertEquals(1, kmLength.compare(mLength));
  }

  @Test
  public void shouldReturnMinusOneWhenCompareLengthGivenSourceIsSmallerThanTarget() {
    Comparable lengthCompare = new KMLength(2);
    Comparable lengthCompare2 = new KMLength(1);

    assertEquals(-1, lengthCompare.compare(lengthCompare2));
  }

}
