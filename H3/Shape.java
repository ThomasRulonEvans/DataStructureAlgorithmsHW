//Thomas Evans
//Assignment #3
//2235 - 01
//Shapes

//Define class
public class Shape{
    
    //Define protected variables
    protected String name;

    //Constructor to pass name
    public Shape(String newName){
        setName(newName);
    } 

    //Setter to set name
    public void setName(String newName){
        name = newName;
    }

    //Getter to get name
    public String getName(){
        return name;
    }
}