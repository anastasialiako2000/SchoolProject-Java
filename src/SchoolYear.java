import java.util.Scanner;

public class SchoolYear {
    private String year;
    private Student[] toddler1;

    private Student[] toddler2;

    private Teacher teacher_toddler1;

    private Teacher teacher_toddler2;

    private static int counter = 0;
    private static SchoolYear[] schoolyear = new SchoolYear[100];

    public SchoolYear(String year, Teacher teacher_toddler1, Teacher teacher_toddler2, Student[] toddler1, Student[] toddler2) {
        this.year = year;
        this.teacher_toddler1 = teacher_toddler1;
        this.teacher_toddler2 = teacher_toddler2;
        this.toddler1 = toddler1;
        this.toddler2 = toddler2;
        schoolyear[counter] = this;
        counter++;
    }

    public String getYear() {
        return year;
    }

    public Teacher getTeacher_toddler1() {
        return teacher_toddler1;
    }

    public Teacher getTeacher_toddler2() {
        return teacher_toddler2;
    }

    public Student[] getToddler1() {
        return toddler1;
    }

    public Student[] getToddler2() {
        return toddler2;
    }

    public static void createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the desired school year:");
        String year = scanner.nextLine();

        // Find the school year by matching the year input
        SchoolYear currentSchoolYear = null;
        for (int i = 0; i < counter; i++) {
            if (schoolyear[i] != null && schoolyear[i].getYear().equals(year)) {
                currentSchoolYear = schoolyear[i];
                break;
            }
        }

        if (currentSchoolYear != null) {
            // Proceed with student enrollment
            System.out.println("Choose the class to enroll in:");
            System.out.println("1. Toddler 1");
            System.out.println("2. Toddler 2");
            int answer = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (answer == 1) {
                for (int i = 0; i < currentSchoolYear.getToddler1().length; i++) {
                    if (currentSchoolYear.getToddler1()[i] == null) {
                        currentSchoolYear.getToddler1()[i] = Student.createStudent();
                        System.out.println("The enrollment process completed successfully.");
                        break;
                    } else if (i + 1 == currentSchoolYear.getToddler1().length) {
                        System.out.println("No available space in the Toddler 1 class.");
                    }
                }
            } else if (answer == 2) {
                for (int i = 0; i < currentSchoolYear.getToddler2().length; i++) {
                    if (currentSchoolYear.getToddler2()[i] == null) {
                        currentSchoolYear.getToddler2()[i] = Student.createStudent();
                        System.out.println("The enrollment process completed successfully.");
                        break;
                    } else if (i + 1 == currentSchoolYear.getToddler2().length) {
                        System.out.println("No available space in the Toddler 2 class.");
                    }
                }
            }
        } else {
            System.out.println("No data available for the provided school year.");
        }
    }

    public static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the desired school year:");
        String year = scanner.nextLine();

        // Find the school year by matching the year input
        SchoolYear currentSchoolYear = null;
        for (int i = 0; i < counter; i++) {
            if (schoolyear[i] != null && schoolyear[i].getYear().equals(year)) {
                currentSchoolYear = schoolyear[i];
                break;
            }
        }

        if (currentSchoolYear != null) {
            boolean check = false;
            System.out.println("Enter the ID of the student to delete:");
            int id = scanner.nextInt();

            for (int i = 0; i < currentSchoolYear.getToddler1().length; i++) {
                if (currentSchoolYear.getToddler1()[i] != null && id == currentSchoolYear.getToddler1()[i].getIdSt()) {
                    check = true;
                    System.out.println("Are you sure you want to delete the student?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int answer = scanner.nextInt();
                    if (answer == 1) {
                        currentSchoolYear.getToddler1()[i] = null;
                        System.out.println("The deletion process completed successfully.");
                    }
                    break;
                }
            }

            for (int j = 0; j < currentSchoolYear.getToddler2().length; j++) {
                if (currentSchoolYear.getToddler2()[j] != null && id == currentSchoolYear.getToddler2()[j].getIdSt()) {
                    check = true;
                    System.out.println("Are you sure you want to delete the student?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int answer = scanner.nextInt();
                    if (answer == 1) {
                        currentSchoolYear.getToddler2()[j] = null;
                        System.out.println("The deletion process completed successfully.");
                    }
                    break;
                }
            }

            if (!check) {
                System.out.println("No student found with the provided ID in the current school year.");
            }
        } else {
            System.out.println("No data available for the provided school year.");
        }
    }

    public static void lookforYearClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the desired school year:");
        String year = scanner.nextLine();
        System.out.println("Enter the class:");
        System.out.println("1. Toddler 1");
        System.out.println("2. Toddler 2");
        int answer = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        boolean yearFound = false;
        for (int i = 0; i < counter; i++) {
            if (schoolyear[i] != null && year.equals(schoolyear[i].getYear())) {
                yearFound = true;
                SchoolYear currentSchoolYear = schoolyear[i];
                if (answer == 1) {
                    System.out.println("The teacher's name in Toddler 1 class for the year " + year + " is " + currentSchoolYear.getTeacher_toddler1().getNameT());
                    System.out.println("The students in Toddler 1 class for the year " + year + " are:");
                    for (int k = 0; k < currentSchoolYear.getToddler1().length; k++) {
                        if (currentSchoolYear.getToddler1()[k] != null) {
                            System.out.println(currentSchoolYear.getToddler1()[k].toString());
                        }
                    }
                    break;
                } else if (answer == 2) {
                    System.out.println("The teacher's name in Toddler 2 class for the year " + year + " is " + currentSchoolYear.getTeacher_toddler2().getNameT());
                    System.out.println("The students in Toddler 2 class for the year " + year + " are:");
                    for (int k = 0; k < currentSchoolYear.getToddler2().length; k++) {
                        if (currentSchoolYear.getToddler2()[k] != null) {
                            System.out.println(currentSchoolYear.getToddler2()[k].toString());
                        }
                    }
                    break;
                }
            }
        }

        if (!yearFound) {
            System.out.println("No data available for the provided school year.");
        }
    }

    public static void compareTeachers() {
        Teacher[] teachersNew = Teacher.getTeachers();
        boolean teachersFound = false;
        for (int i = 0; i < Teacher.getCount(); i++) {
            if (teachersNew[i] != null) {
                for (int j = 0; j < counter; j++) {
                    if (schoolyear[j] != null) {
                        if (teachersNew[i] == schoolyear[j].getTeacher_toddler1()) {
                            teachersFound = true;
                            System.out.println("The teacher " + schoolyear[j].getTeacher_toddler1().getNameT() + " is assigned to Toddler 1 class for the year " + schoolyear[j].getYear());
                        }
                        if (teachersNew[i] == schoolyear[j].getTeacher_toddler2()) {
                            teachersFound = true;
                            System.out.println("The teacher " + schoolyear[j].getTeacher_toddler2().getNameT() + " is assigned to Toddler 2 class for the year " + schoolyear[j].getYear());
                        }
                    }
                }
            }
        }

        if (!teachersFound) {
            System.out.println("No teachers found.");
        }
    }
}