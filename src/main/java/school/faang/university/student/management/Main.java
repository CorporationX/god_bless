package school.faang.university.student.management;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();

        Subject subject1 = new Subject("Физика");
        Subject subject2 = new Subject("Информатика");

        Student student1 = new Student("Иван Иванов");
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(subject1, 5);
        subjects.put(subject2, 4);
        db.addStudentWithSubjects(student1, subjects);

        Student student2 = new Student("Василий Пупкин");
        subjects.remove(subject1);
        subjects.put(subject2, 2);
        db.addStudentWithSubjects(student2, subjects);

        db.printAllStudentsWithMarks();

        db.printAllSubjectsWithStudents();
    }
}
