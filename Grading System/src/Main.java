import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradingSystem gradingSystem = new GradingSystem();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Add Course Credits");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Print Grade Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    gradingSystem.addStudent(new Student(studentID, name));
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseID = scanner.nextInt();
                    System.out.print("Enter Grade (A/B/C/D/F): ");
                    char grade = scanner.next().charAt(0);
                    gradingSystem.addGrade(new Grade(studentID, courseID, grade));
                    break;
                case 3:
                    System.out.print("Enter Course ID: ");
                    courseID = scanner.nextInt();
                    System.out.print("Enter Credits: ");
                    int credits = scanner.nextInt();
                    gradingSystem.addCourseCredits(courseID, credits);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    System.out.println("GPA: " + gradingSystem.calculateGPA(studentID));
                    break;
                case 5:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    gradingSystem.printGradeReport(studentID);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
