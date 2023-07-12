import java.util.Scanner;

public class Student {
    private int idSt;
    private String nameSt;
    private String dateOfBirth;

    private static int count = 0;
    private static Student[] students = new Student[100];

    public Student(String nameSt, String dateOfBirth) {
        this.idSt = count + 1;
        this.nameSt = nameSt;
        this.dateOfBirth = dateOfBirth;
        students[count] = this;
        count++;
    }

    public int getIdSt() {
        return idSt;
    }

    public String getNameSt() {
        return nameSt;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString() {
        return "Student [idSt=" + this.getIdSt() + ", nameSt=" + this.getNameSt() + ", dateOfBirth=" + this.getDateOfBirth() + "]";
    }

    public static Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the student: ");
        String nameSt = scanner.nextLine();
        System.out.println("Date of birth of the student: ");
        String dateOfBirth = scanner.nextLine();
        Student student = new Student(nameSt, dateOfBirth);
        return student;
    }

    public static void printStudents() {
        boolean studentsFound = false;
        for (int i = 0; i < count; i++) {
            if (students[i] != null) {
                studentsFound = true;
                System.out.println(students[i].toString());
            }
        }

        if (!studentsFound) {
            System.out.println("No students found.");
        }
    }
}




