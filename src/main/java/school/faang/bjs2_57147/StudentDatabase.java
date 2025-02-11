package school.faang.bjs2_57147;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class StudentDatabase {
    private static final int GRADE_MIN = 0;
    private static final int GRADE_MAX = 5;
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    public void addStudent(String name, Map<Subject, Integer> subjects) {
        checkValidName(name);
        Student student = new Student(name);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        if (subjects == null) {
            return;
        }

        subjects.entrySet().stream()
                .filter(entry -> entry.getKey() != null)
                .filter(entry -> entry.getValue() == null || isValidGrade(entry.getValue()))
                .forEach(entry -> {
                    studentSubjects.get(student).put(entry.getKey(), entry.getValue());
                    subjectStudents.computeIfAbsent(entry.getKey(), s -> new HashSet<>());
                    subjectStudents.get(entry.getKey()).add(student);
                });
    }

    public void addSubjectToStudent(Subject subject, Student student, int grade) {
        checkValidSubject(subject);
        checkValidStudent(student);
        checkValidGrade(grade);

        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        studentSubjects.get(student).put(subject, grade);

        subjectStudents.computeIfAbsent(subject, k -> new HashSet<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        if (student == null || !studentSubjects.containsKey(student)) {
            return;
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

    public void addNewSubject(Subject subject, List<Student> students) {
        checkValidSubject(subject);
        subjectStudents.computeIfAbsent(subject, k -> new HashSet<>());

        if (students == null) {
            return;
        }

        students.stream()
                .filter(student -> student != null)
                .forEach(student -> {
                    subjectStudents.get(subject).add(student);
                    studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
                    studentSubjects.get(student).put(subject, null);
                });
    }

    public void addStudentToSubject(Subject subject, Student student) {
        checkValidSubject(subject);
        checkValidStudent(student);

        subjectStudents.computeIfAbsent(subject, k -> new HashSet<>());
        subjectStudents.get(subject).add(student);

        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        studentSubjects.get(student).put(subject, null);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
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
        subjectStudents.forEach((subject, students) -> {
            System.out.printf("Предмет %s изучают :\n", subject.getName());
            System.out.println(String.join(", ", (CharSequence) students));
            System.out.println();
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

    private void checkValidName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
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
