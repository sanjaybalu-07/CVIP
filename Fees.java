import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Student {
    private String name;
    private int rollNumber;
    private double feesPaid;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.feesPaid = 0;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void payFess(double amount) {
        feesPaid += amount;
    }

    public double getRemainingFees(double totalFees) {
        return totalFees - feesPaid;
    }
}
    class FeesManagementSystem {
        private double totalFees;
        private Map<Integer, Student> studentMap;

        public FeesManagementSystem(double totalfees) {
            this.totalFees = totalfees;
            this.studentMap = new HashMap<>();
        }

        public void addStudent(Student student) {
            studentMap.put(student.getRollNumber(), student);
        }

        public void recordPayment(int rollNumber, double amount) {
            Student student = studentMap.get(rollNumber);
            if (student != null) {
                student.payFess(amount);
                System.out.println("Payment recorded successfully.");
            } else {
                System.out.println("Student with roll Number " + rollNumber + "not found.");
            }
        }

        public void displayStudentDetails(int rollNumber) {
            Student student = studentMap.get(rollNumber);
            if (student != null) {
                System.out.println("Student Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Fees Paid: " + student.getFeesPaid());
                System.out.println("Remaining Fees: " + student.getRemainingFees(totalFees));
            } else {
                System.out.println("Student with roll number " + rollNumber + "not found.");
            }
        }
    }
    public class Fees{
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            System.out.print("Enter total fees:");
            double totalFees=scanner.nextDouble();
            FeesManagementSystem feesSystem=new FeesManagementSystem(totalFees);

            while (true){
                System.out.println("--------------------------------------");
                System.out.println("1.Add Student");
                System.out.println("2.Record Payment");
                System.out.println("3.Display Student Details");
                System.out.println("4.Exit");
                System.out.println("--------------------------------------");
                System.out.print("Enter your choice: ");
                int choice= scanner.nextInt();

                switch(choice){
                    case 1:
                        System.out.print("Enter Student name:");
                        String name=scanner.next();
                        System.out.print("Enter roll number:");
                        int rollNumber=scanner.nextInt();
                        Student student=new Student(name,rollNumber);
                        feesSystem.addStudent(student);
                        System.out.println("Student added successfully");
                        break;
                    case 2:
                        System.out.print("Enter roll number:");
                        rollNumber=scanner.nextInt();
                        System.out.print("Enter payment amount:");
                        double paymentAmount=scanner.nextDouble();
                        feesSystem.recordPayment(rollNumber,paymentAmount);
                        break;
                    case 3:
                        System.out.print("Enter roll number:");
                        rollNumber=scanner.nextInt();
                        feesSystem.displayStudentDetails(rollNumber);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice");
                }
            }
        }
    }


