package school.faang.bjs2_85966;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentSubjects.remove(student);
        if (grades == null) {
            return;
        }
        for (Subject subject : grades.keySet()) {
            List<Student> students = subjectStudents.get(subject);
            if (students == null) {
                continue;
            }
            students.remove(student);
        }
    }

    public void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            Student student = entry.getKey();
            System.out.println("Студент: " + student.getName());
            for (Map.Entry<Subject, Integer> entry1 : entry.getValue().entrySet()) {
                System.out.println("Предмет: " + entry1.getKey().getName() + " Оценка: " + entry1.getValue());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubject() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Предмет: " + entry.getKey().getName());
            for (Student student : entry.getValue()) {
                System.out.println(" - Студент: " + student.getName());
            }
        }
    }
}
