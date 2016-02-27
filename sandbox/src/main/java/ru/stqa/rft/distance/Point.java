package ru.stqa.rft.distance;

/**
 * Created by User on 21.02.2016.
 */
public class Point {
  double x;
  double y;

  public Point(double xCoord, double yCoord) {
    this.x = xCoord;
    this.y = yCoord;
  }

  public static double distance(Point a, Point b) {
    double dx = a.x - b.x;
    double dy = a.y - b.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

}


