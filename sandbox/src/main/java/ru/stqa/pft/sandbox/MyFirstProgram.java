package ru.stqa.pft.sandbox;

public class MyFirstProgram  {

	public static void main(String[] args){
		Point p1 = new Point(5,4);
		Point p2 = new Point(3,3);
	  System.out.println("Расстояние между точками = " + distance(p1, p2));
    System.out.println("Расстояние между точками = " + p1.distanceTo(p2));




	  hello("people");
		hello("user");
		hello("text");

		//Square s = new Square(5);
		Square s = new Square(5);
		s.l = 5;
		//Square s1 = new Square(3);

		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4, 6);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

	}

	public static void hello(String somebody){
		System.out.println("Hello, " + somebody + "!");
	}


	public static double distance(Point p1, Point p2){
	  double dx = (p1.x - p2.x)*(p1.x - p2.x);
	  double dy = (p1.y - p2.y)*(p1.y - p2.y);
	  return Math.sqrt(dx + dy);
  }
} 