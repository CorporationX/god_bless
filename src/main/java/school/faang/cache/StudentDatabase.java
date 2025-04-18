package school.faang.cache;

import lombok.Getter;

import java.util.*;

@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        Objects.requireNonNull(student, "Студент не может быть null");
        Objects.requireNonNull(subjects, "Предметы не могут быть null");

        studentSubjects.put(student, new HashMap<>(subjects));
        subjects.forEach((subject, grade) ->
                subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student));
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        checkStudentExists(student);

        studentSubjects.get(student).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        checkStudentExists(student);

        studentSubjects.get(student).keySet().forEach(subject -> {
            List<Student> students = subjectStudents.get(subject);
            students.remove(student);
            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        });

        studentSubjects.remove(student);
    }

    public Map<Student, Map<Subject, Integer>> getAllStudentsWithSubjects() {
        Map<Student, Map<Subject, Integer>> result = new HashMap<>();
        studentSubjects.forEach((student, subjects) ->
                result.put(student, new HashMap<>(subjects)));
        return result;
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        Objects.requireNonNull(subject, "Предмет не может быть null");
        Objects.requireNonNull(students, "Список студентов не может быть null");

        subjectStudents.put(subject, new ArrayList<>(students));
        students.forEach(student ->
                studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0));
    }

    public void addStudentToSubject(Student student, Subject subject) {
        checkSubjectExists(subject);

        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        checkSubjectExists(subject);

        subjectStudents.get(subject).remove(student);
        if (subjectStudents.get(subject).isEmpty()) {
            subjectStudents.remove(subject);
        }

        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).remove(subject);
            if (studentSubjects.get(student).isEmpty()) {
                studentSubjects.remove(student);
            }
        }
    }

    public Map<Subject, List<Student>> getAllSubjectsWithStudents() {
        Map<Subject, List<Student>> result = new HashMap<>();
        subjectStudents.forEach((subject, students) ->
                result.put(subject, new ArrayList<>(students)));
        return result;
    }

    public Integer getGrade(Student student, Subject subject) {
        checkStudentExists(student);
        return studentSubjects.get(student).get(subject);
    }

    public void updateGrade(Student student, Subject subject, int grade) {
        checkStudentExists(student);
        if (!studentSubjects.get(student).containsKey(subject)) {
            throw new IllegalArgumentException("Студент не изучает данный предмет");
        }
        studentSubjects.get(student).put(subject, grade);
    }

    private void checkStudentExists(Student student) {
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Студент не найден в базе");
        }
    }

    private void checkSubjectExists(Subject subject) {
        if (!subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException("Предмет не найден в базе");
        }
    }
}
