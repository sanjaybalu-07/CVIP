import java.util.Scanner;
public class Bmi{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Weight in KiloGrams:");
        double weight = sc.nextDouble();
        System.out.print("Enter Height in Meters:");
        double height = sc.nextDouble();
        double BMI = weight / (height*height);
        System.out.println("The Body Mass Index(BMI) is "+BMI+"kg/m2");
        if (BMI < 18.5)
            System.out.println("underweight");
        else if (BMI < 25)
            System.out.println("normal");
        else if (BMI < 30)
            System.out.println("overweight");
        else
            System.out.println("obese");
    }
}