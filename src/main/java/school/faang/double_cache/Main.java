package school.faang.double_cache;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();
        Student student1 = new Student("Андрей");
        Student student2 = new Student("Алексей");
        Student student3 = new Student("Александр");
        Subject informatics = new Subject("Информатика");
        Subject mathematics = new Subject("Математика");
        Subject physics = new Subject("Физика");

        database.addStudentWithGrades(student1, Map.of(informatics, 2));
        database.addStudentWithGrades(student2, Map.of(mathematics, 3));
        database.addStudentWithGrades(student3, Map.of(physics, 4));
        database.addSubjectForStudent(student2, informatics, 3);
        database.addSubjectWithStudents(physics, List.of(student1, student2));
        database.addStudentForSubject(student3, informatics);
        database.printAllSubjectsWithStudents();
        database.printAllStudentsWithGrades();

        database.removeStudentWithSubjects(student1);
        database.removeStudentFromSubject(student3, informatics);
        database.printAllSubjectsWithStudents();
        database.printAllStudentsWithGrades();
    }
}
