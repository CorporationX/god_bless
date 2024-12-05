package school.faang.task_45225;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> subjectsAndGradesByStudents;
    private final Map<Subject, List<Student>> studentsBySubject;

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Integer> subjects) {
        if (subjectsAndGradesByStudents.containsKey(student)) {
            throw new IllegalArgumentException("Student with id = " + student.getId() + " is already exist");
        }
        subjectsAndGradesByStudents.computeIfAbsent(student, k -> subjects);
        for (Subject subject : subjects.keySet()) {
            studentsBySubject.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectAndGradeForExistingStudent(Student student, Subject subject, int grade) {
        subjectsAndGradesByStudents.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        studentsBySubject.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void deleteStudentWithSubjectsAndGrades(Student student) {
        subjectsAndGradesByStudents.remove(student);
        for (var entry : studentsBySubject.entrySet()) {
            entry.getValue().remove(student);
            if (entry.getValue().isEmpty()) {
                studentsBySubject.remove(entry.getKey());
            }
        }
    }

    public void printAllStudentsWithSubjectsAndGrades() {
        for (var entry : subjectsAndGradesByStudents.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (studentsBySubject.containsKey(subject)) {
            throw new IllegalArgumentException("Subject with id = " + subject.getId() + " is already exist");
        }
        studentsBySubject.put(subject, students);
        for (var student : students) {
            subjectsAndGradesByStudents.computeIfAbsent(student,
                    k -> new HashMap<>()).computeIfAbsent(subject,
                        k -> subjectsAndGradesByStudents.get(student).getOrDefault(subject, 0));
        }
    }

    public void addStudentAtExistingSubject(Student student, Subject subject) {
        List<Student> currentStudents = studentsBySubject.get(subject);
        if (currentStudents == null) {
            throw new IllegalArgumentException("Students don't exist in subject");
        }
        currentStudents.add(student);
        subjectsAndGradesByStudents.computeIfAbsent(student, k -> new HashMap<>()).computeIfAbsent(subject,
                k -> subjectsAndGradesByStudents.get(student).getOrDefault(subject, 0));
    }

    public void deleteStudentAtSubject(Student student, Subject subject) {
        List<Student> currentStudents = studentsBySubject.get(subject);
        currentStudents.remove(student);
        if (currentStudents.isEmpty()) {
            studentsBySubject.remove(subject);
        }
        subjectsAndGradesByStudents.remove(student);
    }


    public void printAllSubjectsWithStudents() {
        for (var entry : studentsBySubject.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
