import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRecordSystem system = new StudentRecordSystem();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. View All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    Student student = new Student(studentID, name, age, department);
                    system.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    Student retrievedStudent = system.getStudent(id);
                    if (retrievedStudent != null) {
                        System.out.println(retrievedStudent);
                    }
                    else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    system.displayAllStudents();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}