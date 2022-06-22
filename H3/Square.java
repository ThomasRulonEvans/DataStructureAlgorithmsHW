//Thomas Evans
//Assignment #3
//2235 - 01
//Square

public class Square extends Shape{

    //Define protected variables
    protected Point firstPoint;
    protected Point secondPoint;

    //Constructor to pass variables
    public Square(String newName, Point pointOne, Point pointTwo) {
        super(newName);
        firstPoint = pointOne;
        secondPoint = pointTwo;
    }

    //Getter for length
    public int getLength(){
        int a = firstPoint.getX() - secondPoint.getX();
        int length = Math.abs(a);
        return length;
    }
    //getter for height
    public int getHeight(){
        int a = firstPoint.getY() - secondPoint.getY();
        int height = Math.abs(a);
        return height;
    }

    //Getter for area
    public int getArea(){
        int area = getHeight() * getLength();
        return area;
    }

    //Getter for perimeter
    public int getPerimeter(){
        return (getHeight() + getLength()) * 2;
    } 
}