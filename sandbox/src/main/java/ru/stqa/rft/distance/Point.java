package ru.stqa.rft.distance;

/**
 * Created by User on 21.02.2016.
 */
public class Point {

  public double x;
  public double y;

  Point(double xcoord, double ycoord) {
    this.x = xcoord;
    this.y = ycoord;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));

  }

}


