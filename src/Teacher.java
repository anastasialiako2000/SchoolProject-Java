import java.util.Scanner;

public class Teacher {
    private int idT;
    private String nameT;
    private int ssn;

    private static int count = 0;
    private static Teacher[] teachers = new Teacher[100];

    public Teacher(String nameT, int ssn) {
        this.idT = count + 1;
        this.nameT = nameT;
        this.ssn = ssn;
        teachers[count] = this;
        count++;
    }

    public static int getCount() {
        return count;
    }
    public int getIdT() {
        return idT;
    }

    public static Teacher[] getTeachers() {
        return teachers;
    }

    public String getNameT() {
        return nameT;
    }

    public int getSsn() {
        return ssn;
    }

    public String toString() {
        return "Teacher [idT=" + this.getIdT() + ", nameT=" + this.getNameT() + ", ssn=" + this.getSsn() + "]";
    }

    public static void createTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the Teacher: ");
        String nameT = scanner.nextLine();
        System.out.println("SSN of the Teacher:");
        int ssn = scanner.nextInt();
        Teacher teacher = new Teacher(nameT, ssn);
        System.out.println(teacher.toString());
    }

    public static void printTeachers() {
        boolean teachersFound = false;
        for (int i = 0; i < count; i++) {
            if (teachers[i] != null) {
                teachersFound = true;
                System.out.println(teachers[i].toString());
            }
        }

        if (!teachersFound) {
            System.out.println("No teachers found.");
        }
    }

    public static void SsnTeachers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter SSN of the teacher to search: ");
        int ssn = scanner.nextInt();
        boolean teacherFound = false;
        for (int i = 0; i < count; i++) {
            if (teachers[i] != null) {
                if (ssn == teachers[i].getSsn()) {
                    teacherFound = true;
                    System.out.println("The details of the teacher with the given SSN are:");
                    System.out.println(teachers[i].toString());
                    System.out.println();
                    break;
                }
            }
        }
        if (!teacherFound) {
            System.out.println("No teacher found with the provided SSN.");
        }
    }
}