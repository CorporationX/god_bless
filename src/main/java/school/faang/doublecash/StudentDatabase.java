package school.faang.doublecash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects;
    private Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        studentSubjects = new HashMap<>();
        subjectStudents = new HashMap<>();
    }

    public void addNewStudent(Student student, Map<Subject, Integer> mapSubject) {
        studentSubjects.put(student, mapSubject);
        mapSubject.forEach((a, b) -> subjectStudents.computeIfAbsent(a, k -> new ArrayList<>()).add(student));
    }

    public void addNewSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        studentSubjects.remove(student);
        subjectStudents.forEach((a, b) -> b.remove(student));
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> mapStudent : studentSubjects.entrySet()) {
            System.out.println("Студент: " + mapStudent.getKey().getName());
            for (Map.Entry<Subject, Integer> mapSubject : mapStudent.getValue().entrySet()) {
                System.out.println("Примедмет: " + mapSubject.getKey().getName()
                        + ". Оценка: " + mapSubject.getValue());
            }
        }
    }

    public void addNewSubjectsWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        students.forEach(e -> studentSubjects.computeIfAbsent(e, k -> new HashMap<>()).put(subject, null));
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.get(subject).add(student);
        studentSubjects.computeIfAbsent(student, r -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        subjectStudents.get(subject).remove(student);
        studentSubjects.get(student).remove(subject);
    }

    public void printAllSubjectsAndStudent() {
        for (Map.Entry<Subject, List<Student>> mapSubject : subjectStudents.entrySet()) {
            System.out.println("Предмет: " + mapSubject.getKey().getName() + "\nСтуденты: ");
            for (Student student : mapSubject.getValue()) {
                System.out.println(" - " + student.getName());
            }
        }
    }
}