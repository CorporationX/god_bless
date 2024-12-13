package school.faang.task_45298;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    public static void addStudentToSubjectGradesByStudent(Map<Student, Map<Subject, Integer>> subjectGradesByStudent,
                                                          Map<Subject, List<Student>> studentsBySubject,
                                                          Student student, Map<Subject, Integer> grades) {
        subjectGradesByStudent.put(student, grades);

        for (var subject : grades.keySet()) {
            studentsBySubject.putIfAbsent(subject, new ArrayList<>());
            studentsBySubject.get(subject).add(student);
        }
    }

    public static void addGradeToSubjectGradesByStudent(Map<Student, Map<Subject, Integer>> subjectGradesByStudent,
                                                        Map<Subject, List<Student>> studentsBySubject,
                                                        Student student, Subject subject, Integer grade) {
        if (subjectGradesByStudent.containsKey(student)) {
            subjectGradesByStudent.get(student).put(subject, grade);

            studentsBySubject.putIfAbsent(subject, new ArrayList<>());
            studentsBySubject.get(subject).add(student);
        } else {
            System.out.println("Student '" + student + "' is not found");
        }
    }

    public static void deleteStudentFromSubjectGradesByStudent(
            Map<Student, Map<Subject, Integer>> subjectGradesByStudent,
            Map<Subject, List<Student>> studentsBySubject, Student student) {

        Map<Subject, Integer> grades = subjectGradesByStudent.get(student);
        for (var subject : grades.keySet()) {
            studentsBySubject.get(subject).remove(student);
        }

        subjectGradesByStudent.remove(student);
    }

    public static void printAllFromSubjectGradesByStudent(Map<Student, Map<Subject, Integer>> subjectGradesByStudent) {
        for (var entry : subjectGradesByStudent.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Grades: " + entry.getValue());
        }
    }

    public static void addSubjectToStudentsBySubject(Map<Subject, List<Student>> studentsBySubject,
                                                     Map<Student, Map<Subject, Integer>> subjectGradesByStudent,
                                                     Subject subject, List<Student> students) {
        studentsBySubject.put(subject, students);

        for (var student : students) {
            subjectGradesByStudent.putIfAbsent(student, new HashMap<>());
            subjectGradesByStudent.get(student).put(subject, null);
        }
    }

    public static void addStudentToStudentsBySubject(Map<Subject, List<Student>> studentsBySubject,
                                                     Map<Student, Map<Subject, Integer>> subjectGradesByStudent,
                                                     Subject subject, Student student) {
        if (studentsBySubject.containsKey(subject)) {
            studentsBySubject.get(subject).add(student);

            subjectGradesByStudent.putIfAbsent(student, new HashMap<>());
            subjectGradesByStudent.get(student).put(subject, null);
        } else {
            System.out.println("Subject '" + subject + "' is not found");
        }
    }

    public static void deleteStudentFromStudentsBySubject(Map<Subject, List<Student>> studentsBySubject,
                                                          Map<Student, Map<Subject, Integer>> subjectGradesByStudent,
                                                          Subject subject, Student student) {
        if (studentsBySubject.containsKey(subject)) {
            studentsBySubject.get(subject).remove(student);

            subjectGradesByStudent.get(student).remove(subject);
        } else {
            System.out.println("Subject '" + subject + "' is not found");
        }
    }

    public static void printAllStudentsBySubject(Map<Subject, List<Student>> studentsBySubject) {
        for (var entry : studentsBySubject.entrySet()) {
            System.out.println("Subject: " + entry.getKey() + ", Students: " + entry.getValue());
        }
    }
}
