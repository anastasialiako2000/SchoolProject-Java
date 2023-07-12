import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Create Teacher");
            System.out.println("2. Create Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Look for Year and Class");
            System.out.println("5. Compare Teachers");
            System.out.println("6. Search Teacher by SSN");
            System.out.println("7. Print Teachers");
            System.out.println("8. Print Students");
            System.out.println("0. Exit");
            System.out.println("==========================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Teacher.createTeacher();
                    break;
                case 2:
                    SchoolYear.createStudent();
                    break;
                case 3:
                    SchoolYear.deleteStudent();
                    break;
                case 4:
                    SchoolYear.lookforYearClass();
                    break;
                case 5:
                    SchoolYear.compareTeachers();
                    break;
                case 6:
                    Teacher.SsnTeachers();
                    break;
                case 7:
                    Teacher.printTeachers();
                    break;
                case 8:
                    Student.printStudents();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}