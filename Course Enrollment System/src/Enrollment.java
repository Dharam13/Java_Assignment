public class Enrollment {
    private int[][] studentCourses;
    private int[] count;

    public Enrollment(int numStudents, int maxCoursesPerStudent) {
        studentCourses = new int[numStudents][maxCoursesPerStudent];
        count = new int[numStudents];
    }

    public void enroll(int studentID, int courseID) {
        if (count[studentID] < studentCourses[studentID].length) {
            studentCourses[studentID][count[studentID]] = courseID;
            count[studentID]++;
            System.out.println("Student " + studentID + " enrolled in course " + courseID);
        } else {
            System.out.println("Student " + studentID + " cannot enroll in more courses.");
        }
    }

    public void drop(int studentID, int courseID) {
        boolean found = false;
        for (int i = 0; i < count[studentID]; i++) {
            if (studentCourses[studentID][i] == courseID) {
                studentCourses[studentID][i] = studentCourses[studentID][count[studentID] - 1];
                count[studentID]--;
                found = true;
                System.out.println("Student " + studentID + " dropped course " + courseID);
                break;
            }
        }
        if (!found) {
            System.out.println("Student " + studentID + " is not enrolled in course " + courseID);
        }
    }

    public void getEnrolledCourses(int studentID, Course[] courseCatalog) {
        System.out.println("Courses enrolled by student " + studentID + ":");
        for (int i = 0; i < count[studentID]; i++) {
            for (Course course : courseCatalog) {
                if (course.getCourseID() == studentCourses[studentID][i]) {
                    System.out.println(course);
                    break;
                }
            }
        }
    }
}

