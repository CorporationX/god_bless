package school.faang.task_57062;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        checkStudentExistence(student);
        checkStudentNull(student);
        studentSubjects.put(student, subjects);
        for (Map.Entry<Subject, Integer> entry : subjects.entrySet()) {
            subjectStudents.computeIfAbsent(entry.getKey(), studentNew -> new ArrayList<>()).add(student);
        }
    }

    public void addNewSubjectForStudent(Student student, Subject subject, int grade) {
        checkStudentNull(student);
        checkSubjectNull(subject);
        studentSubjects.computeIfAbsent(student, studentNew -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, studentNew -> new ArrayList<>()).add(student);
    }

    public void removeStudentAndHisSubject(Student student) {
        checkStudentNull(student);
        Map<Subject, Integer> subjects = studentSubjects.remove(student);
        if (subjects != null) {
            for (Subject subject : subjects.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
    }

    public void printAllStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Предмет: " + entry.getKey());
            System.out.println("  Студенты: " + entry.getValue());
        }
        System.out.println("\n");
    }

    private void checkStudentExistence(Student student) {
        if (studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Студент уже существует!");
        }
    }

    private void checkStudentNull(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Поле студент пустое");
        }
    }

    private void checkSubjectNull(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Поле оценка пустое");
        }
    }
}
