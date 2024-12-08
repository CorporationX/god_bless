package school.faang.task_45277;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();

        Student student1 = new Student("Sofia");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Tom");

        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");
        Subject chemistry = new Subject("Chemistry");

        database.addStudentWithGrades(student1, Map.of(math, 90, physics, 85));
        database.addStudentWithGrades(student2, Map.of(math, 78, chemistry, 88));
        database.printAllStudentsWithGrades();
        database.addStudentToSubject(student3, chemistry);
        database.removeStudentFromSubject(student1, math);
        database.printAllSubjectsWithStudents();
    }
}