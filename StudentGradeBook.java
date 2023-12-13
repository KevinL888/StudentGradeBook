import java.util.HashMap;
import java.util.Scanner;

public class StudentGradeBook {
    private final HashMap<Integer, Student> students;

    public StudentGradeBook() {
        students = new HashMap<>();
    }

    public HashMap<Integer, Student> getStudents(){
        return students;
    }

    public Student getStudent(Integer studentNumber) {
        return students.getOrDefault(studentNumber,null);
    }
    public void addStudent(Integer studentNumber, Student student) {
        students.put(studentNumber, student);
    }

    public void removeStudent(Integer studentNumber) {
        students.remove(studentNumber);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeBook gradeBook = new StudentGradeBook();

        while (true) {
            System.out.println("\n=== Student Grade Book Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Grades");
            System.out.println("4. View Grades");
            System.out.println("5. Calculate Average Grade");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student number: ");
                    Integer studentNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    Student student = new Student(name);
                    student.addStudentInfo();
                    gradeBook.addStudent(studentNumber, student);
                    System.out.println(name + " added to the grade book.");
                    break;

                case 2:
                    System.out.print("Enter student number to remove: ");
                    Integer studentToRemove = scanner.nextInt();
                    String studentName = gradeBook.getStudents().get(studentToRemove).studentName();
                    if (studentName == null){
                        System.out.println("Student Number is not in the database");
                        break;
                    }
                    gradeBook.removeStudent(studentToRemove);
                    System.out.println("Student Number:"+ studentToRemove+" - " + studentName + " removed from the grade book.");
                    break;

                case 3:
                    System.out.print("Enter student number to update grades: ");
                    Integer studentNumberToUpdate = scanner.nextInt();

                    Student currentStudent = gradeBook.students.get(studentNumberToUpdate);
                    if (currentStudent == null){
                        System.out.println("Student Number is not in the database");
                        break;
                    }
                    currentStudent.updateGrades();
                    break;

                case 4:
                    System.out.print("Enter student number to view grades: ");
                    Integer studentNumberToView = scanner.nextInt();
                    Student studentToView = gradeBook.students.get(studentNumberToView);
                    if (studentToView == null){
                        System.out.println("Student Number is not in the database");
                        break;
                    }
                    studentToView.viewGrades();
                    break;

                case 5:
                    System.out.print("Enter student name to calculate average grade: ");
                    Integer studentNumberToCalculate = scanner.nextInt();
                    Student studentToCalc = gradeBook.students.get(studentNumberToCalculate);
                    if (studentToCalc == null){
                        System.out.println("Student Number is not in the database");
                        break;
                    }
                    studentToCalc.calculateAverageGrade();
                    break;

                case 6:
                    System.out.println("Exiting the Student Grade Book. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}
