//Thomas Evans
//Assignment #3
//2235 - 01
//Test

//Define class
public class Test {

    //Define main
    public static void main(String[] args) {

                //Point.java tests
                Point pointDefault = new Point();
                System.out.println("My first point is: " + pointDefault.getX() + "," + pointDefault.getY());
                Point pointPassParams = new Point(5,6);
                System.out.println("My second point is: " + pointPassParams.getX() + "," + pointPassParams.getY());
                pointPassParams.setX(2);
                pointPassParams.setY(2);
                System.out.println("My second point is now: " + pointPassParams.getX() + "," + pointPassParams.getY());

                //Square.java Tests
                Square bobSquare = new Square("Bob", pointDefault, pointPassParams);
                System.out.println("The name of my square is: " + bobSquare.getName());
                System.out.println("The length of my square is: " + bobSquare.getLength());
                System.out.println("The height of my square is: " + bobSquare.getHeight());
                System.out.println("The area of my square is: " + bobSquare.getArea());
                System.out.println("The perimeter of my square is: " + bobSquare.getPerimeter());

                //Circle.java Tests
                Circle bobbieCircle = new Circle("Bobbie", pointDefault, 1);
                System.out.println("The name of my circle is: " + bobbieCircle.getName());
                System.out.println("The radius of my circle is: " + bobbieCircle.getRadius());
                System.out.println("The center of my circle is at: " + bobbieCircle.getCenter().X + "," + bobbieCircle.getCenter().Y);
                System.out.println("The area of my circle is: " + bobbieCircle.getArea());
                System.out.println("The circumference of my circle is: " + bobbieCircle.getCircumference());
    }
}