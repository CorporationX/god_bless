package school.faang.double_cache;

public class StudentDatabaseTest {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudent("Poll", "Math", 4);
        studentDatabase.addStudent("Poll", "English", 3);
        studentDatabase.addStudent("Nik", "Math", 5);
        studentDatabase.addStudent("Dani", "Math", 4);
        studentDatabase.addStudent("Wook", "Math", 2);
        studentDatabase.addStudent("Wook", "English", 2);
        System.out.println(studentDatabase.getStudentSubjects());
        System.out.println(studentDatabase.getSubjectStudents());
        studentDatabase.addSubject(new Student("Nik"), "English", 5);
        System.out.println(studentDatabase.getStudentSubjects());
        System.out.println(studentDatabase.getSubjectStudents());
        studentDatabase.printAllStudentSubject();
        studentDatabase.dellStudent(new Student("Wook"));
        System.out.println(studentDatabase.getStudentSubjects());
        System.out.println(studentDatabase.getSubjectStudents());
        studentDatabase.printAllStudentSubject();
    }
}
