package ru.stqa.rft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.rft.distance.Point;

/**
 * Created by User on 27.02.2016.
 */
public class PointTests {

  @Test
  public void testDistance () {
    Point p1 = new Point(2, 2);
    Point p2 = new Point(4, 4);
    Assert.assertEquals(Point.distance(p1, p2), 2.8284271247461903);
  }

  @Test
  public void testDistance2 () {
    Point p3 = new Point(1, 2);
    Point p4 = new Point(3, 4);
    Assert.assertEquals(Point.distance(p3, p4), 2.8284271247461903);
  }

  @Test
  public void testDistance3 () {
    Point p3 = new Point(5, 3);
    Point p4 = new Point(9, 4);
    Assert.assertEquals(Point.distance(p3, p4), 4.123105625617661);
  }
}
