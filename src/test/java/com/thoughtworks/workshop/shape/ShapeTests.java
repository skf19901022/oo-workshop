package com.thoughtworks.workshop.shape;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeTests {

  @Test
  public void shouldReturn4WhenGetShapeAreaGivenWidthIs3AndLength4() {
    Rectangle rectangle = new Rectangle(2, 4);
    while (rectangle.getLength() >= rectangle.getWidth()) {
      rectangle.increaseWidth();
    }
    assertEquals(rectangle.getLength(), rectangle.getWidth());
  }
}
