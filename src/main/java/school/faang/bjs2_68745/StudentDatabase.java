package school.faang.bjs2_68745;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentDatabase {
    public static final String GRADE_CANNOT_BE_EMPTY = "Оценка не должна быть пустая";
    public static final String GRADE_CANNOT_BE_NEGATIVE = "Оценка не должна быть отрицательная";
    private final Map<Student, Map<Subject, Integer>> studentSubjects; // хранит информацию о студентах, их предметах и оценках.
    private final Map<Subject, List<Student>> subjectStudents; // хранит информацию о предметах и списке студентов, изучающих каждый предмет.

    public StudentDatabase() {
        this.studentSubjects = new HashMap<>();
        this.subjectStudents = new HashMap<>();
    }

    //Добавление нового студента и его предметов с оценками.
    public boolean addStudentDatabaseInfo(String studentName, String subjectName, Integer grade) {
        if (grade == null) {
            throw new IllegalArgumentException(GRADE_CANNOT_BE_EMPTY);
        } else if (grade < 0) {
            throw new IllegalArgumentException(GRADE_CANNOT_BE_NEGATIVE);
        }
        Student student = new Student(studentName);
        Subject subject = new Subject(subjectName);

        addStudentToSubjects(subject, student);
        addSubjectToStudent(student, subject, grade);

        return false;
    }

    private void addStudentToSubjects(Subject subject, Student student) {
        List<Student> students = subjectStudents.getOrDefault(subject, new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
            subjectStudents.put(subject, students);
        }
    }

    private void addSubjectToStudent(Student student, Subject subject, Integer grade) {
        // Map<Student, Map<Subject, Integer>> studentSubjects; // хранит информацию о студентах, их предметах и оценках.
        Map<Subject, Integer> studentSubjectsValue = studentSubjects.get(student);
        if (studentSubjectsValue == null) {
            studentSubjectsValue = new HashMap<>();
        } else {
            Integer gradeValue = studentSubjectsValue.get(subject);
            if (gradeValue == null) {

            }
        }
    }

    public boolean removeStudent(String studentName) {
        Student student = new Student(studentName);
        studentSubjects.remove(student);
        return false;
    }

    public boolean removeSubject(String subject) {
        return false;
    }

    public void printAllStudents() {
        for (var entry : studentSubjects.entrySet()) {
            System.out.printf("Студент: %s\n", entry.getKey());
            entry.getValue().forEach((subject, grade) -> {
                System.out.printf("\tПредмет: %s, Оценка: %d\n", subject, grade);
            });
        }
    }

    public void printAllSubjects() {
        for (var entry : subjectStudents.entrySet()) {
            System.out.printf("Предмет: %s\n", entry.getKey());            
            entry.getValue().forEach((student) -> {
                System.out.printf("\tСтудент: %s\n", student);
            });
        }
    }

}
