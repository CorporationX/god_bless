package school.faang.bjs2_57147;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private static final int GRADE_MIN = 0;
    private static final int GRADE_MAX = 5;
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(@NonNull Student student, @NonNull Map<Subject, Integer> subjects) {
        checkValidStudent(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        if (subjects == null) {
            throw new IllegalArgumentException("Предметы должны быть указаны");
        }

        subjects.entrySet().stream()
                .filter(entry -> entry.getKey() != null)
                .filter(entry -> entry.getValue() == null || isValidGrade(entry.getValue()))
                .forEach(entry -> {
                    studentSubjects.get(student).put(entry.getKey(), entry.getValue());
                    subjectStudents.computeIfAbsent(entry.getKey(), s -> new ArrayList<>()).add(student);
                });
    }

    public void addSubjectToStudent(@NonNull Subject subject, @NonNull Student student, int grade) {
        checkValidSubject(subject);
        checkValidStudent(student);
        checkValidGrade(grade);

        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(@NonNull Student student) {
        if (student == null || !studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Список студентов не указан");
        }

        studentSubjects.get(student).keySet()
                .forEach(subject -> subjectStudents.get(subject).remove(student));
        studentSubjects.remove(student);
    }

    public void printStudentInfo() {
        studentSubjects.forEach((student, subjects) -> {
            System.out.printf("Зачетка студента %s :\n", student.getName());
            subjects.forEach((subject, grade) ->
                    System.out.printf("%s - %d\n", subject.getName(), grade));
        });
    }

    public void addNewSubject(@NonNull Subject subject, @NonNull List<Student> students) {
        checkValidSubject(subject);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());

        if (students == null) {
            throw new IllegalArgumentException("Список студентов не указан");
        }

        students.stream()
                .filter(student -> student != null)
                .forEach(student -> {
                    subjectStudents.get(subject).add(student);
                    studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
                    studentSubjects.get(student).put(subject, null);
                });
    }

    public void addStudentToSubject(@NonNull Subject subject, @NonNull Student student) {
        checkValidSubject(subject);
        checkValidStudent(student);

        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromSubject(@NonNull Subject subject, @NonNull Student student) {
        checkValidSubject(subject);
        checkValidStudent(student);

        studentSubjects.computeIfPresent(student, (key, subjects) -> {
            subjects.remove(subject);
            return subjects;
        });

        subjectStudents.computeIfPresent(subject, (key, students) -> {
            students.remove(student);
            return students;
        });
    }

    public void printSubjectsWithStudents() {
        subjectStudents.forEach((k, v) -> {
            System.out.println(k.getName());
            v.forEach(s ->
                    System.out.println(new StringBuilder("----").append(s.getName())));
        });
    }

    private boolean isValidGrade(int grade) {
        return grade <= GRADE_MAX && grade >= GRADE_MIN;
    }

    private void checkValidGrade(int grade) {
        if (!isValidGrade(grade)) {
            throw new IllegalArgumentException("Вы ввели недопустимую оценку (" + grade + "), " +
                    "допустимое значение от " + GRADE_MIN + " до " + GRADE_MAX);
        }
    }

    private void checkValidSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Предмет не может быть пустым");
        }
    }

    private void checkValidStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Студент не может быть пустым");
        }
    }
}
