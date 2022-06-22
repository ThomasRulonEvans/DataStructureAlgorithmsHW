import java.util.Scanner;

public class User_input {
    public static void main(String[] args) {
        String name;
        int age;
        Double height;

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name.");
        name = input.nextLine();
        System.out.println("Please enter your age.");
        age = input.nextInt();
        System.out.println("Please enter your height.");
        height = input.nextDouble();
        System.out.println("Hello " + name);
        System.out.println("I'm " + age + " years old.");
        System.out.println("I'm " + height + " feet tall.");

    }
}
