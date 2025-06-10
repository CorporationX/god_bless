package school.faang.bjs2_79756;

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
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectForStudentWithGrade(Student student, Subject subject, int grade) {
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("студент не найден");
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        grades.put(subject, grade);

        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void removeStudentWithSubject(Student student) {
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("студент не найден");
        }
        studentSubjects.remove(student);
        for (List<Student> students : subjectStudents.values()) {
            students.remove(student);
        }
    }

    public void printStudentsWithGrades() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println("subject: " + subject.getName());
            for (Student student : entry.getValue()) {
                System.out.println("    student: " + student.getName());
            }
        }
    }
}
