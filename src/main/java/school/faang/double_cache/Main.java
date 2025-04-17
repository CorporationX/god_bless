package school.faang.double_cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();
        Student student1 = new Student("Андрей");
        Subject informatics = new Subject("Информатика");
        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(informatics, 2);
        database.addStudentWithGrades(student1, grades1);
        Student student2 = new Student("Алексей");
        Subject mathematics = new Subject("Математика");
        Map<Subject, Integer> grades2 = new HashMap<>();
        grades2.put(mathematics, 3);
        database.addStudentWithGrades(student2, grades2);
        Student student3 = new Student("Александр");
        Subject physics = new Subject("Физика");
        Map<Subject, Integer> grades3 = new HashMap<>();
        grades3.put(physics, 4);

        database.addStudentWithGrades(student3, grades3);
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
