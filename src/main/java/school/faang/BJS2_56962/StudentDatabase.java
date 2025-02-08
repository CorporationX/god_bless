package school.faang.BJS2_56962;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {

    private static final int MIN_GRADE = 1;
    private static final int MAX_GRADE = 5;

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public Student addStudent(String name) {
        Student student = new Student(name);
        validateStudentNotExists(student);
        return student;
    }

    public Subject addSubject(String name) {
        Subject subject = new Subject(name);
        validateSubjectNotExists(subject);
        return subject;
    }

    public void addStudentSubjectsGrade(String studentName, String subjectName, int grade) {
        checkGrade(grade);
        Student student = addStudent(studentName);
        Subject subject = addSubject(subjectName);
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectGrade(Student student, String subjectName, int grade) {
        checkGrade(grade);
        validateStudentNotExists(student);
        Subject subject = new Subject(subjectName);
        validateSubjectExists(subject);
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.put(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void deleteStudentSubject(Student student) {
        validateStudentExists(student);
        studentSubjects.remove(student);
        for (List<Student> students : subjectStudents.values()) {
            students.remove(student);
        }
        System.out.printf("Студент %s и его предметы удалены\n", student.getName());
    }

    public void printAllSubjectAndStudent() {
        System.out.println("Список предметов и студентов изучающих их");
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println(entry.getKey().getName() + ":");
            for (Student student : entry.getValue()) {
                System.out.printf("- %s\n", student.getName());
            }
        }
    }

    public void addSubjectAndListStudents(String subjectName, List<Student> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("Список студентов не может быть пустым или null");
        }
        Subject subject = addSubject(subjectName);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).addAll(students);

        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentSubject(String studentName, Subject subject) {
        Student student = addStudent(studentName);
        validateSubjectExists(subject);
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, null);
        subjectStudents.get(subject).add(student);
    }

    public void deleteStudentFromSubject(Student student, Subject subject) {
        validateStudentExists(student);
        validateSubjectNotExists(subject);

        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects != null) {
            subjects.remove(subject);
            if (subjects.isEmpty()) {
                studentSubjects.remove(student);
            }
        }

        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
    }

    public void printAllStudentGradeAndSubject() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentEntry : studentSubjects.entrySet()) {
            System.out.printf("Студент %s :\n", studentEntry.getKey().getName());
            for (Map.Entry<Subject, Integer> subjectIntegerEntry : studentEntry.getValue().entrySet()) {
                System.out.printf("Предмет - %s, оценка - %d\n",
                        subjectIntegerEntry.getKey(), subjectIntegerEntry.getValue());
            }
        }
    }

    private void checkGrade(int grade) {
        if (grade < MIN_GRADE || grade > MAX_GRADE) {
            throw new IllegalArgumentException("Оценка %d некорректна, она должна быть в диапазоне от %d до %d"
                    .formatted(grade, MIN_GRADE, MAX_GRADE));
        }
    }

    public void validateStudentExists(Student student) {
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Студента %s не существует".formatted(student));
        }
    }

    public void validateStudentNotExists(Student student) {
        if (studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Студент %s уже существует".formatted(student));
        }
    }

    private void validateSubjectExists(Subject subject) {
        if (!subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException("Предмета %s не существует".formatted(subject));
        }
    }

    private void validateSubjectNotExists(Subject subject) {
        if (subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException("Предмет %s уже существует".formatted(subject));
        }
    }
}
