package ru.stqa.pft.sandbox;

public class Point {
  double x;
  double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double distanceTo(Point p1){
    double dx = (this.x - p1.x)*(this.x - p1.x);
    double dy = (this.y - p1.y)*(this.y - p1.y);
    return Math.sqrt(dx + dy);
  }

}
