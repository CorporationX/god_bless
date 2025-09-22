package school.faang.doublecash;

import java.util.ArrayList;
import java.util.Map;

public class StudentService {

    private final StudentDatabase database;

    public StudentService(StudentDatabase database) {
        this.database = database;
    }

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        if (!StudentValidator.validateStudentAndSubjects(student, subjects)) {
            return;
        }

        database.getStudentSubjects().put(student, subjects);
        subjects.keySet().forEach(subject ->
                database.getSubjectStudents().computeIfAbsent(subject, k -> new ArrayList<>()).add(student)
        );
    }

    public void removeStudent(Student student) {
        if (StudentValidator.isNull(student)) {
            return;
        }

        Map<Subject, Integer> subjects = database.getStudentSubjects().remove(student);
        if (subjects != null) {
            subjects.keySet().forEach(subject -> {
                database.getSubjectStudents().get(subject).remove(student);
                if (database.getSubjectStudents().get(subject).isEmpty()) {
                    database.getSubjectStudents().remove(subject);
                }
            });
        }
    }

    public void printStudents() {
        if (database.getStudentSubjects().isEmpty()) {
            System.out.println("Нет данных о студентах.");
            return;
        }
        database.getStudentSubjects().forEach((student, subjects) -> {
            System.out.println("\nСтудент: " + student.getName());
            subjects.forEach((subject, grade) -> System.out.println(" " + subject.getName() + ": " + grade));
        });
    }
}