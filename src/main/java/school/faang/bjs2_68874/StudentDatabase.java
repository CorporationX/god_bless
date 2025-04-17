package school.faang.bjs2_68874;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjectsWithMarks) {
        for (Map.Entry<Subject, Integer> entry : subjectsWithMarks.entrySet()) {
            addStudentToSubject(student, entry.getKey());
            addSubjectToStudent(entry.getKey(), entry.getValue(), student);
        }
    }

    public void addSubject(Subject subject, List<Student> students) {
        students.forEach(student -> {
            if (studentSubjects.containsKey(student)) {
                addStudentToSubject(student, subject);
                addSubjectToStudent(subject, null, student);
            }
        });
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
    }

    public void addSubjectToStudent(Subject subject, Integer mark, Student student) {
        studentSubjects.computeIfAbsent(student, key -> new HashMap<>()).put(subject, mark);
    }

    public void removeStudent(Student student) {
        var subjects = studentSubjects.remove(student);
        if (subjects != null) {
            for (var subject : subjects.keySet()) {
                removeStudentFromSubject(student, subject);
            }
        }
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        var subjects = studentSubjects.get(student);
        if (subjects != null) {
            subjects.remove(subject);
        }

        var students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
    }

    public void printAllStudents() {
        System.out.println("\nСписок студентов:");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.printf("%s изучает предметы:%n", entry.getKey().name());

            entry.getValue().forEach((subject, mark) ->
                    System.out.printf("\t- %s (Оценка: %d)%n", subject.name(), mark)
            );
        }
    }

    public void printAllSubjects() {
        System.out.println("\nСписок предметов:");
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.printf("Предмет \"%s\" изучают студенты:%n", entry.getKey().name());

            entry.getValue().forEach(student -> System.out.printf("\t- %s%n", student.name()));
        }
    }
}
