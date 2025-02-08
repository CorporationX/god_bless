package school.faang.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> subjectsWithGrades) {
        studentSubjects.put(student, subjectsWithGrades);
        for (Subject subject : subjectsWithGrades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectWithGrade(Subject subject, Student student, int grade) {
        validateGrade(grade);
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void deleteStudentAndHisSubjects(Student student) {
        Map<Subject, Integer> subjectsMap = studentSubjects.remove(student);
        if (subjectsMap != null) {
            for (Subject subject : subjectsMap.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
    }

    public void printAllStudentsWithSubjectsAndGrades() {
        Set<Student> students = studentSubjects.keySet();
        for (Student student : students) {
            System.out.println("Студент: " + student.getName());
            System.out.println("Успеваемость: ");
            for (Map.Entry<Subject, Integer> entry : studentSubjects.get(student).entrySet()) {
                System.out.println(" - " + entry.getKey().toString() +
                        " " + entry.getValue().toString());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        for (Student student : students) {
            if (!subjectStudents.get(subject).contains(student)) {
                subjectStudents.get(subject).add(student);
            }
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        if (!subjectStudents.containsKey(subject)) {
            System.out.println("Такой предмет отсутствует: " + subject);
            return;
        }

        if (subjectStudents.get(subject).contains(student)) {
            System.out.println("Студент уже числиться в этом предмете");
            return;
        }
        subjectStudents.get(subject).add(student);
        System.out.println("Студент успешно добавлен!");
    }

    public void printAllSubjectsWithStudents() {
        Set<Subject> subjects = subjectStudents.keySet();
        for (Subject subject : subjects) {
            System.out.println("Предмет: " + subject.getName());
            System.out.println("Список студентов: ");
            for (Student student : subjectStudents.get(subject)) {
                System.out.println(" - " + student.getName());
            }
        }
    }

    private void validateGrade(int grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Недопустимое значение оценки");
        }
    }
}