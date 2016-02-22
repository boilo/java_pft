package ru.stqa.rft.distance;

/**
 * Created by User on 22.02.2016.
 */
public class Distance {

  public static void main(String[] args) {
    Point p1 = new Point(2, 2);
    Point p2 = new Point(4, 4);
    System.out.println("Расстояние между точками равно " + Point.distance(p1, p2));
  }

}
