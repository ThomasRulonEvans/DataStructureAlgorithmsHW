import jdk.vm.ci.code.site.Site;

public class methodExample {
    public static void noParameters(){
        System.out.println("Theres nothing here");
    }
    public static double heightConveter(double h){
        double height = h*0.3048;
        return height;
    }
    public static int overExample(int i){
        return i;
    }
    public static double overExample(double i){
        return i;
    }
    public static String overExample(String i){
        return i;
    }
    public static double pie(){
        double pie = 3.14;
        return pie;
    }
    public static double circle(double i){
        double pi = pie();
        double circleArea = pi*i*2;
        return circleArea;
    }
    public static void main(String[] args) {
        noParameters();
        double heightInMeters = heightConveter(5);
        System.out.println(heightInMeters);
        System.out.println(overExample(1));
        System.out.println(overExample(1.1));
        System.out.println(overExample("1"));
        System.out.println(circle(5));
    }
}
