package school.faang;

import java.util.*;

public class StudentDatabase {

    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        studentSubjects.put(student, subjects);
        subjects.forEach((subject, grade) -> {
            if (!subjectStudents.containsKey(subject)) {
                subjectStudents.put(subject, new ArrayList<>());
            }
            subjectStudents.get(subject).add(student);
        });
    }

    public void addSubjectToStudent(Subject subject, Student name) {
        if (studentSubjects.containsKey(name)) {
            studentSubjects.get(name).put(subject, 0);
            if (!subjectStudents.containsKey(subject)) {
                subjectStudents.put(subject, new ArrayList<>());
            }
            subjectStudents.get(subject).add(name);
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
        studentSubjects.remove(student);

        Iterator<Map.Entry<Subject, List<Student>>> it = subjectStudents.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Subject, List<Student>> entry = it.next();
            entry.getValue().remove(student);
            if (entry.getValue().isEmpty()) {
                it.remove();
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
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).put(subject, 0);
        } else {
            studentSubjects.put(student, new HashMap<>());
            studentSubjects.get(student).put(subject, 0);
        }
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
