import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Course[] courseCatalog = {
                new Course(1, "Mathematics", 3),
                new Course(2, "Physics", 4),
                new Course(3, "Chemistry", 4),
                new Course(4, "Computer Science", 3)
        };

        Enrollment enrollment = new Enrollment(100, 10);

        while (true) {
            System.out.println("1. Enroll Student");
            System.out.println("2. Drop Course");
            System.out.println("3. View Enrolled Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseID = scanner.nextInt();
                    enrollment.enroll(studentID, courseID);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    System.out.print("Enter Course ID: ");
                    courseID = scanner.nextInt();
                    enrollment.drop(studentID, courseID);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    enrollment.getEnrolledCourses(studentID, courseCatalog);
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
