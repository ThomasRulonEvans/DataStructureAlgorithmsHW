//Thomas Evans
//Assignment #3
//2235 - 01
//Circle

public class Circle extends Shape{

    //Define protected variables
    protected Point center;
    protected double radius;

    //Constructor to pass variables
    public Circle(String newName, Point centerPoint, int rad) {
        super(newName);
        center = centerPoint;
        radius = rad;
    }

    //Getter radius
    public double getRadius(){
        return radius;
    }

    //Getter for center
    public Point getCenter(){
        return center;
    }

    //Getter for area
    public double getArea(){
        double rSquared = getRadius() * getRadius();
        double area = 3.14 * rSquared;
        return area;
    }

    //Getter for circumference
    public double getCircumference(){
        return 2 * 3.14 * getRadius();
    } 
}