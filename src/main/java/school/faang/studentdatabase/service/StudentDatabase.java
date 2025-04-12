package school.faang.studentdatabase.service;

import lombok.RequiredArgsConstructor;
import school.faang.studentdatabase.entity.Student;
import school.faang.studentdatabase.entity.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects;
    public final Map<Subject, List<Student>> subjectStudents;

    public void addStudentAndSubjects(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void updateSubjectsForStudent(Student student, Subject subject, int grade) {
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).put(subject, grade);
            List<Student> students = subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());
            if (!students.contains(student)) {
                students.add(student);
            }
        } else {
            throw new IllegalArgumentException("Student does not exist");
        }
    }

    public void removeStudentAndSubjects(Student student) {
        if (studentSubjects.containsKey(student)) {
            for (Subject subject : studentSubjects.get(student).keySet()) {
                subjectStudents.get(subject).remove(student);
            }
            studentSubjects.remove(student);
        }
    }

    public String printAllStudentsAndGrades() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Student, Map<Subject, Integer>> studentMap : studentSubjects.entrySet()) {
            Map<Subject, Integer> subjectMap = studentMap.getValue();
            sb.append(studentMap.getKey()).append(subjectMap);
        }
        return sb.toString();
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
        }
    }

    public void addStudentToSubject(Subject subject, Student student) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        if (subjectStudents.containsKey(subject)) {
            subjectStudents.get(subject).remove(student);
        }
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).remove(subject);
        }
    }

    public String printAllSubjectsAndStudents() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Subject, List<Student>> subjects : subjectStudents.entrySet()) {
            sb.append(subjects.getKey()).append(": ");
            for (Student student : subjects.getValue()) {
                sb.append(student);
            }
        }
        return sb.toString();
    }
}