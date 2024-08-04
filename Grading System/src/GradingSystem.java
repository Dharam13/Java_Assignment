public class GradingSystem {
    private Student[] students;
    private Grade[] grades;
    private int[] courseIDs;
    private int[] courseCredits;

    private int studentCount;
    private int gradeCount;
    private int courseCount;

    private static final int MAX_STUDENTS = 100;
    private static final int MAX_GRADES = 500;
    private static final int MAX_COURSES = 50;

    public GradingSystem() {
        students = new Student[MAX_STUDENTS];
        grades = new Grade[MAX_GRADES];
        courseIDs = new int[MAX_COURSES];
        courseCredits = new int[MAX_COURSES];

        studentCount = 0;
        gradeCount = 0;
        courseCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < MAX_STUDENTS) {
            students[studentCount++] = student;
        } else {
            System.out.println("Maximum number of students reached.");
        }
    }

    public void addGrade(Grade grade) {
        if (gradeCount < MAX_GRADES) {
            grades[gradeCount++] = grade;
        } else {
            System.out.println("Maximum number of grades reached.");
        }
    }

    public void addCourseCredits(int courseID, int credits) {
        if (courseCount < MAX_COURSES) {
            courseIDs[courseCount] = courseID;
            courseCredits[courseCount++] = credits;
        } else {
            System.out.println("Maximum number of courses reached.");
        }
    }

    private int getCourseCredits(int courseID) {
        for (int i = 0; i < courseCount; i++) {
            if (courseIDs[i] == courseID) {
                return courseCredits[i];
            }
        }
        return 0; // default if courseID is not found
    }

    public double calculateGPA(int studentID) {
        int totalCredits = 0;
        int totalPoints = 0;
        for (int i = 0; i < gradeCount; i++) {
            Grade grade = grades[i];
            if (grade.getStudentID() == studentID) {
                int credits = getCourseCredits(grade.getCourseID());
                totalCredits += credits;
                totalPoints += gradeToPoints(grade.getGrade()) * credits;
            }
        }
        return totalCredits == 0 ? 0 : (double) totalPoints / totalCredits;
    }

    private int gradeToPoints(char grade) {
        switch (grade) {
            case 'A': return 4;
            case 'B': return 3;
            case 'C': return 2;
            case 'D': return 1;
            case 'F': return 0;
            default: return 0;
        }
    }

    public void printGradeReport(int studentID) {
        System.out.println("Grade Report for Student ID: " + studentID);
        for (int i = 0; i < gradeCount; i++) {
            Grade grade = grades[i];
            if (grade.getStudentID() == studentID) {
                System.out.println("Course ID: " + grade.getCourseID() + ", Grade: " + grade.getGrade());
            }
        }
        System.out.println("GPA: " + calculateGPA(studentID));
    }
}
