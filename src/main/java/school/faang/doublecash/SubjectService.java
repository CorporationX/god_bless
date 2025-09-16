package school.faang.doublecash;

import java.util.HashMap;
import java.util.List;

public class SubjectService {

    private final StudentDatabase database;

    public SubjectService(StudentDatabase database) {
        this.database = database;
    }

    public void addSubject(Subject subject, List<Student> students, int defaultGrade) {
        if (!StudentValidator.validateSubject(subject) || students == null || students.isEmpty()) {
            return;
        }

        database.getSubjectStudents().put(subject, students);

        for (Student student : students) {
            database.getStudentSubjects().computeIfAbsent(student, k -> new HashMap<>()).put(subject, defaultGrade);
        }
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (student == null || subject == null) {
            return;
        }

        if (database.getStudentSubjects().containsKey(student)) {
            database.getStudentSubjects().get(student).remove(subject);
        }

        if (database.getSubjectStudents().containsKey(subject)) {
            database.getSubjectStudents().get(subject).remove(student);
            if (database.getSubjectStudents().get(subject).isEmpty()) {
                database.getSubjectStudents().remove(subject);
            }
        }
    }

    public void printAllSubjectsAndStudents() {
        if (database.getSubjectStudents().isEmpty()) {
            System.out.println("Нет данных о предметах.");
            return;
        }
        database.getSubjectStudents().forEach((subject, students) -> {
            System.out.println("\nПредмет: " + subject.getName());
            students.forEach(student -> System.out.println(" " + student.getName()));
        });
    }
}