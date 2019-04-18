package ru.stqa.pft.sandbox;

public class MyPoint {
  public static void main(String[] args) {
    Point p1 = new Point(5, 4);
    Point p2 = new Point(3, 3);
    System.out.println("Расстояние между точками = " + distance(p1, p2));
    System.out.println("Расстояние между точками = " + p1.distanceTo(p2));
  }

  public static double distance(Point p1, Point p2){
    double dx = (p1.x - p2.x)*(p1.x - p2.x);
    double dy = (p1.y - p2.y)*(p1.y - p2.y);
    return Math.sqrt(dx + dy);
  }
}
