package school.faang.BJS2_32503;

public class Main {
    public static void main(String[] args) {
        StudentManagementService studentService = new StudentManagementService();

        Student student1 = new Student("Alice", "Engineering", 2023);
        Student student2 = new Student("Bob", "Engineering", 2023);
        Student student3 = new Student("Charlie", "Mathematics", 2022);
        Student student4 = new Student("David", "Mathematics", 2023);
        Student student5 = new Student("Eve", "Engineering", 2022);

        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);
        studentService.addStudent(student4);
        studentService.addStudent(student5);

        System.out.println("Grouped students:");
        studentService.printGroupedStudents();

        System.out.println("\nRemoving Bob:");
        studentService.removeStudent("Bob", "Engineering", 2023);

        System.out.println("Grouped students after removing Bob:");
        studentService.printGroupedStudents();

        System.out.println("\nStudents (Engineering, 2022):");
        studentService.findStudentsByFacultyAndYear("Engineering", 2022)
                .forEach(System.out::println);
    }
}
