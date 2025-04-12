package school.faang.bjs2_69888;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        if (!studentSubjects.containsKey(student)) {
            studentSubjects.put(student, subjects);
        }

        for (Map.Entry<Subject, Integer> entry : subjects.entrySet()) {
            subjectStudents.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        studentSubjects.remove(student);
        for (Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            entry.getValue().remove(student);
        }
    }

    public void printAllStudents() {
        for (Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey().getName());
            for (Entry<Subject, Integer> subjectEntry : entry.getValue().entrySet()) {
                System.out.printf("-- %s mark %d\n", subjectEntry.getKey().getName(), subjectEntry.getValue());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (!subjectStudents.containsKey(subject)) {
            subjectStudents.put(subject, students);
        }

        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        subjectStudents.get(subject).remove(student);
        studentSubjects.get(student).remove(subject);
    }

    public void printAllSubjects() {
        for (Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println(entry.getKey().getName());
            for (Student student : entry.getValue()) {
                System.out.printf("-- %s\n", student.getName());
            }
        }
    }
}
