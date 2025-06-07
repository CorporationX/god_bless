package school.faang.double_cache;

import java.util.List;

public class StudentDatabaseTest {
    public static void main(String[] args) throws IllegalAccessException {
        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudent("Poll", "Math", 4);
        studentDatabase.addStudent("Poll", "English", 3);
        studentDatabase.addStudent("Nik", "Math", 5);
        studentDatabase.addStudent("Dani", "Math", 4);
        studentDatabase.addStudent("Wook", "Math", 2);
        studentDatabase.addStudent("Wook", "English", 2);
        studentDatabase.printAllStudentSubject();
        studentDatabase.printAllSubjectStudent();
        studentDatabase.addSubject(new Student("Nik"), "English", 5);
        studentDatabase.deleteStudent(new Student("Wook"));
        studentDatabase.printAllStudentSubject();
        studentDatabase.printAllSubjectStudent();
        studentDatabase.addStudentSubject(new Student("Dani"), new Subject("English"));
        studentDatabase.deleteSubjectStudent(new Subject("Math"), new Student("Poll"));
        studentDatabase.printAllStudentSubject();
        studentDatabase.printAllSubjectStudent();
        studentDatabase.assignStudentsToSubject("Sport", List.of(new Student("Dani"), new Student("Poll")));
        studentDatabase.printAllStudentSubject();
        studentDatabase.printAllSubjectStudent();
    }
}
