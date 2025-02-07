package school.faang.bjs2_56955;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        if (!studentSubjects.containsKey(student)) {
            System.out.println("Student " + student.getName() + " does not exist");
            return;
        }
        studentSubjects.get(student).put(subject, grade);
        List<Student> students = subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudentAndSubjectForStudent(Student student) {
        if (!studentSubjects.containsKey(student)) {
            System.out.println("Student " + student.getName() + " does not exist");
            return;
        }
        studentSubjects.remove(student);

        subjectStudents.entrySet().removeIf(entry -> {
            List<Student> students = entry.getValue();
            if (students != null) {
                entry.getValue().remove(student);
                return students.isEmpty();
            }
            return false;
        });
    }

    public void printAllStudentsAndRangeForStudent() {
        if (studentSubjects.isEmpty()) {
            System.out.println("Student not found.");
            return;
        }
        studentSubjects.forEach((student, subjects) -> {
            System.out.println("Student: " + student.getName());
            System.out.println("Subjects:");
            subjects.forEach((subject, grade) -> {
                System.out.println("\t" + subject.getName() + ": " + grade);
            });
            System.out.println();
        });
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        List<Student> studentList = subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());

        for (Student student : students) {
            studentList.add(student);
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (subjectStudents.containsKey(subject)) {
            subjectStudents.get(subject).remove(student);
            if (subjectStudents.get(subject).isEmpty()) {
                subjectStudents.remove(subject);
            }
        }

        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).remove(subject);
        }
    }

    public void printAllSubjectsAndStudents() {
        if (subjectStudents.isEmpty()) {
            System.out.println("No subjects found.");
            return;
        }

        subjectStudents.forEach((subject, students) -> {
            System.out.println("Subject: " + subject.getName());
            System.out.println("Students:");
            students.forEach(student -> System.out.println("\t" + student.getName()));
            System.out.println();
        });
    }
}
