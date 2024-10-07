package school.faang.fifthTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsMapManager {
    private static Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private static Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addNewStudentAndSubjects(Student student, List<SubjectWithGrade> subjectsWithGrade) {
        studentGrades.putIfAbsent(student, new HashMap<>());
        for (SubjectWithGrade subjectWithGrade : subjectsWithGrade) {
            studentGrades.get(student).put(subjectWithGrade.getSubject(), subjectWithGrade.getGrade());
            subjectStudents.putIfAbsent(subjectWithGrade.getSubject(), new ArrayList<>());
            subjectStudents.get(subjectWithGrade.getSubject()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentGrades.putIfAbsent(student, new HashMap<>());
        studentGrades.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        studentGrades.remove(student);
        for (List<Student> students : subjectStudents.values()) {
            students.remove(student);
        }
    }

    public void printAllStudentsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            System.out.println("Student: " + entry.getKey().getName());
            for (Map.Entry<Subject, Integer> grades : entry.getValue().entrySet()) {
                System.out.println("  Subject: " + grades.getKey().getName() + ", Grade: " + grades.getValue());
            }
        }
    }

    public void addNewSubjectForStudents(Subject subject, List<Student> students) {
        for (Student student : students) {
            subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
            studentGrades.putIfAbsent(student, new HashMap<>());
            studentGrades.get(student).put(subject, 0); // Add subject with default 0 grade
        }
    }

    public void addStudentToSubject(Subject subject, Student student) {
        subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
        studentGrades.putIfAbsent(student, new HashMap<>());
        studentGrades.get(student).put(subject, 0); // Add subject with default 0 grade
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        subjectStudents.get(subject).remove(student);
        studentGrades.get(student).remove(subject);
    }

    public void printAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Subject: " + entry.getKey().getName());
            for (Student student : entry.getValue()) {
                System.out.println("  Student: " + student.getName());
            }
        }
    }

}
