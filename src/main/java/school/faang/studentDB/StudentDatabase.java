package school.faang.studentDB;

import java.util.*;

public class StudentDatabase {

    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        studentSubjects.put(student, subjects);
        subjects.forEach((subject, grade) -> {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        });
    }

    public void addSubjectToStudent(Subject subject, Student student) {
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).put(subject, 0);
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubject(Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).addAll(students);

        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, 0);
        }
    }

    public void deleteStudent(Student student) {
        Map<Subject, Integer> subjectsMap = studentSubjects.remove(student);
        if (subjectsMap != null) {
            for (Subject subject : subjectsMap.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                    if (students.isEmpty()) {
                        subjectStudents.remove(subject);
                    }
                }
            }
        }
    }

    public void printDatabase() {
        studentSubjects.forEach((student, subjects) -> {
            System.out.println(student.getName());
            subjects.forEach((subject, grade) -> {
                System.out.println(subject.getName() + ": " + grade);
            });
        });
    }

    public void addStudentToSubject(Student student, Subject subject) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>())
                .put(subject, 0);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).remove(subject);
        }
        if (studentSubjects.containsKey(subject)) {
            studentSubjects.get(subject).remove(student);
            if (studentSubjects.get(subject).isEmpty()) {
                studentSubjects.remove(subject);
            }
        }
    }

    public void printSubjectStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.println(subject.getName());
            students.forEach(student -> {
                System.out.println(student.getName());
            });
        });
    }
}
