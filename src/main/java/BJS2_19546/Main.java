package BJS2_19546;

public class Main {
    public static void main(String[] args) {
        Student.studentsStorage.add(new Student("Artem V.", "Programming", 1));
        Student.studentsStorage.add(new Student("Vlad E.", "Design", 2));
        Student.studentsStorage.add(new Student("Xenia A.", "Programming", 1));
        Student.studentsStorage.add(new Student("Pavel V.", "Design", 3));
        Student.studentsStorage.add(new Student("Maria M.", "Design", 2));

        Student.groupStudentsByFacultyAndYear();

        Student.printStudents();

        Student.removeStudent("Xenia A.", "Programming", 1);

        Student.getStudentsByFacultyAndYear("Xenia A.", "Programming", 1);

        Student.printStudents();
    }
}