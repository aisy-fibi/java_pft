package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test
  public void testDistance(){
    Point p1 = new Point(5,7);
    Point p2 = new Point(2,3);
    Assert.assertEquals(p1.distanceTo(p2), 5.0);
   }

   @Test
  public void testDistanceZero(){
     Point p1 = new Point(5,7);
     Point p2 = new Point(5,7);
     Assert.assertEquals(p1.distanceTo(p2), 0.0);
   }

   @Test
  public void testDistanceChangedPoints(){
    Point p1 = new Point(5,7);
    Point p2 = new Point(2,3);
    Assert.assertEquals(p2.distanceTo(p1), p1.distanceTo(p2));
   }

   @Test
  public void testDistanceNegativePoint(){
     Point p1 = new Point(1,2);
     Point p2 = new Point(-2,-2);
     Assert.assertEquals(p1.distanceTo(p2), 5.0);
   }

   @Test
  public void testDistanceToZero(){
    Point p1 = new Point(3,4);
    Point p2 = new Point(0,0);
    Assert.assertEquals(p1.distanceTo(p2), 5.0);
   }

   @Test
   public void testDistanceToItself(){
    Point p1 = new Point(1,1);
    Assert.assertEquals(p1.distanceTo(p1), 0.0);
   }
}
