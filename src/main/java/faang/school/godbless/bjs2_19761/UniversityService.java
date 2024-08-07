package faang.school.godbless.bjs2_19761;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.AbstractMap.SimpleEntry;

public class UniversityService {
    Map<Student, Map<Subject, Integer>> students;
    Map<Subject, List<Student>> subjects;

    public UniversityService() {
        students = new HashMap<>();
        subjects = new HashMap<>();
    }

    public void addStudentWithMarks(SimpleEntry<Student, Map<Subject, Integer>> studentData) {
        var student = studentData.getKey();
        students.put(student, studentData.getValue());
        for (Map.Entry<Subject, Integer> entry : studentData.getValue().entrySet()) {
            subjects.computeIfAbsent(entry.getKey(), s -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectToStudent(SimpleEntry<Subject, Integer> subject, Student student) {
        students.computeIfAbsent(student, s -> new HashMap<>())
                .put(subject.getKey(), subject.getValue());
        subjects.computeIfAbsent(subject.getKey(), s -> new ArrayList<>()).add(student);
    }

    public void deleteStudent(Student student) {
        students.get(student).keySet().forEach(s -> subjects.get(s).remove(student));
        students.remove(student);
    }

    public Student createStudent(String name) {
        return new Student(name);
    }

    public Subject[] generateInitialSubjects() {
        return new Subject[]{
                new Subject("Java"),
                new Subject("Python"),
                new Subject("Go")};
    }

    public Map<Subject, Integer> assignMarksToSubjects(Subject[] subjects, int[] marks) {
        if (subjects.length != marks.length) {
            throw new IllegalArgumentException("Number of subjects and marks should be the same");
        }

        var subjectMarks = new HashMap<Subject, Integer>();
        var last = subjects.length - 1;
        for (int i = 0; i <= last; i++) {
            subjectMarks.put(subjects[i], marks[i]);
        }
        return subjectMarks;
    }

    public void printData() {
        printStudents();
        System.out.println("----");
        printSubjects();
        System.out.println("--------------------------------");
    }

    public void printStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : students.entrySet()) {
            System.out.println("Student: " + entry.getKey());
            printMarks(entry.getValue());
        }
    }

    public void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("    Student: " + student);
        }
    }

    public void printSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : subjects.entrySet()) {
            System.out.println("Subject: " + entry.getKey().getName());
            printStudents(entry.getValue());
        }
    }

    public void printMarks(Map<Subject, Integer> marks) {
        for (Map.Entry<Subject, Integer> entry : marks.entrySet()) {
            System.out.println("    " + entry.getKey().getName() + ": " + entry.getValue());
        }
    }
}
