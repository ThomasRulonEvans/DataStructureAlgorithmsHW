//Thomas Evans
//Assignment #3
//2235 - 01
//Point

//Define class
public class Point {

    //Define protected values
    protected Integer X;
    protected Integer Y;

    //Constructor default point values
    public Point(){
        setX(0);
        setY(0);
    }

    //Passthrough constructor method
    public Point(Integer x, Integer y){
        setX(x);
        setY(y);
    }

    //Setter methods
    public void setX(Integer x){
        this.X = x;
    }
    public void setY(Integer y){
        this.Y = y;
    }

    //Getter methods
    public Integer getX(){
        return X;
    }
    public Integer getY(){
        return Y;
    }
}