package school.faang.BJS2_32493;

public class Main {
    public static void main(String[] args) {
        StudentSubjectManager manager = new StudentSubjectManager();

        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Subject subject1 = new Subject(1, "Mathematics");
        Subject subject2 = new Subject(2, "Computer Science");

        manager.addStudent(student1);
        manager.addStudent(student2);

        manager.addSubjectForStudent(student1, subject1, 90);
        manager.addSubjectForStudent(student1, subject2, 85);
        manager.addSubjectForStudent(student2, subject1, 80);

        System.out.println("All students and their grades:");
        manager.printStudentGrades();

        manager.removeStudent(student1);
        System.out.println("\nAfter removing Alice:");
        manager.printStudentGrades();

        manager.addNewSubject(subject2);
        manager.addStudentToSubject(subject2, student2);

        System.out.println("\nAll subjects and their students:");
        manager.printSubjectAndStudents();
    }
}
