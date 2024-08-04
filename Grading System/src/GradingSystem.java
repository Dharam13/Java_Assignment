import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradingSystem {
    private List<Student> students;
    private List<Grade> grades;
    private Map<Integer, Integer> courseCredits;

    public GradingSystem() {
        students = new ArrayList<>();
        grades = new ArrayList<>();
        courseCredits = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void addCourseCredits(int courseID, int credits) {
        courseCredits.put(courseID, credits);
    }

    public double calculateGPA(int studentID) {
        int totalCredits = 0;
        int totalPoints = 0;
        for (Grade grade : grades) {
            if (grade.getStudentID() == studentID) {
                int credits = courseCredits.get(grade.getCourseID());
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
        for (Grade grade : grades) {
            if (grade.getStudentID() == studentID) {
                System.out.println("Course ID: " + grade.getCourseID() + ", Grade: " + grade.getGrade());
            }
        }
        System.out.println("GPA: " + calculateGPA(studentID));
    }
}
