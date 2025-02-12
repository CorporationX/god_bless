package school.faang.BJS2_56950;

import java.util.*;

public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentAndSubjectWithInteger(Student student, Subject subject, int grade) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Student or Subject can't be null");
        }

        this.studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        this.subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    private void findStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student can't be null");
        }

        if (!studentSubjects.containsKey(student)) {
            throw new NoSuchElementException(
                    String.format("Student with name %s not found in the database.", student.getName())
            );
        }
    }

    public void addNewSubjectWithInteger(Student student, Subject subject, int grade) {
        findStudent(student);

        if (studentSubjects.get(student).containsKey(subject)) {
            throw new IllegalArgumentException("such an item already exists");
        }

        addStudentAndSubjectWithInteger(student, subject, grade);
    }

    public void deleteStudent(Student student) {
        findStudent(student);
        studentSubjects.remove(student);
        subjectStudents.entrySet().removeIf(entry -> {
            entry.getValue().remove(student);
            return entry.getValue().isEmpty();
        });
    }

    public void showStudentWithSubject() {
        getStudentSubjects().forEach((student, subjectMap) -> {
            System.out.printf("%nИмя студенда %s%n", student.getName());
            System.out.printf("Предметы:%n");
            subjectMap.forEach((subject, integer) -> {
                System.out.printf("- Предмет %-10s | Оценка: %-3s %n", subject.getName(), integer);
            });

        });
    }

    public void addNewSubjectWithStudents(List<Student> students, Subject subject) {
        if (subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException("such an item already exists");
        }

        students.forEach(student -> {
            addNewSubjectWithInteger(student, subject, 0);
        });
    }

    private void findSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject can't be null");
        }

        if (!subjectStudents.containsKey(subject)) {
            throw new NoSuchElementException(
                    String.format("Subject with name %s not found in the database.", subject.getName())
            );
        }
    }

    public void addNewStudentForSubject(Student student, Subject subject, int grade) {
        findSubject(subject);
        findStudent(student);

        if (studentSubjects.get(student).containsKey(subject)) {
            throw new IllegalArgumentException("such an item already exists");
        }

        addStudentAndSubjectWithInteger(student, subject, grade);
    }

    public void deleteStudentFromSubject(Student student, Subject subject) {
        findSubject(subject);
        findStudent(student);
        studentSubjects.get(student).remove(subject);
        subjectStudents.get(subject).remove(student);
    }

    public void showSubjectWithStudent() {
        subjectStudents.forEach((subject, studentList) -> {
            System.out.printf("%nПредмет: %s%n", subject.getName());
            System.out.printf("Студенты изучающий предмет:%n");
            studentList.forEach(student -> {
                System.out.printf("Имя студента: %s%n", student.getName());
            });

        });
    }

    public Map<Student, Map<Subject, Integer>> getStudentSubjects() {
        return Collections.unmodifiableMap(studentSubjects);
    }

    public Map<Subject, List<Student>> getSubjectStudents() {
        return Collections.unmodifiableMap(subjectStudents);
    }
}
