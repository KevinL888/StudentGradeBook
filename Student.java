import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    String name;
    ArrayList<Integer> grades;

    public Student(String name) {
        grades = new ArrayList<>();
        this.name = name;
    }

    public String studentName() {
        return name;
    }

    public void addStudentInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter grade for subject " + (i + 1) + ": ");
            grades.add(scanner.nextInt());
        }
    }

    public void updateGrades() {
        grades.clear();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter grade for subject " + (i + 1) + ": ");
            grades.add(scanner.nextInt());
        }
    }

    public void viewGrades() {
        System.out.println("Grades for " + name + ":");
        for (int i = 0; i < grades.size(); i++) {
            System.out.println("Subject " + (i + 1) + ": " + grades.get(i));
        }
    }

    public void calculateAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
                sum += grade;
        }
        double average = (double) sum / grades.size();
            System.out.println("Average grade for " + name + ": " + average);
    }
}
