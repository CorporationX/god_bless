package faang.school.godbless.week1.Students;


import java.util.*;

public class Main {
    private static List<Students> students = new ArrayList<>();

    public static void main(String[] args) {
        // Adding sample students
        students.add(new Students("Alice", "Engineering", 1));
        students.add(new Students("Bob", "Engineering", 2));
        students.add(new Students("Charlie", "Science", 1));
        students.add(new Students("David", "Science", 2));
        students.add(new Students("Eve", "Arts", 1));
        students.add(new Students("Frank", "Arts", 2));

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Infinite loop for menu
        while (true) {
            System.out.println("1. Add Student\n2. Remove Student\n3. Find Students\n4. List All Students\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    removeStudent(scanner);
                    break;
                case 3:
                    findStudents(scanner);
                    break;
                case 4:
                    listAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a student
    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter student year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        students.add(new Students(fullName, faculty, year));
        System.out.println("Student added successfully.");
    }

    // Method to remove a student
    private static void removeStudent(Scanner scanner) {
        System.out.print("Enter student full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter student year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean removed = students.removeIf(student -> student.getFullName().equals(fullName) &&
                student.getFaculty().equals(faculty) &&
                student.getYear() == year);
        if (removed) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to find students by faculty and year
    private static void findStudents(Scanner scanner) {
        System.out.print("Enter faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Students> foundStudents = new ArrayList<>();
        for (Students student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                foundStudents.add(student);
            }
        }

        if (foundStudents.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Found students:");
            for (Students student : foundStudents) {
                System.out.println(student);
            }
        }
    }

    // Method to list all students grouped by faculty and year
    private static void listAllStudents() {
        Map<String, Map<Integer, List<Students>>> groupedStudents = new HashMap<>();

        for (Students student : students) {
            groupedStudents
                    .computeIfAbsent(student.getFaculty(), k -> new HashMap<>())
                    .computeIfAbsent(student.getYear(), k -> new ArrayList<>())
                    .add(student);
        }

        for (Map.Entry<String, Map<Integer, List<Students>>> facultyEntry : groupedStudents.entrySet()) {
            String faculty = facultyEntry.getKey();
            Map<Integer, List<Students>> yearMap = facultyEntry.getValue();

            System.out.println("Faculty: " + faculty);
            for (Map.Entry<Integer, List<Students>> yearEntry : yearMap.entrySet()) {
                int year = yearEntry.getKey();
                List<Students> studentList = yearEntry.getValue();

                System.out.println("  Year: " + year);
                for (Students student : studentList) {
                    System.out.println("    " + student);
                }
            }
        }
    }
}