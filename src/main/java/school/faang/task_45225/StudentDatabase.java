package school.faang.task_45225;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
            throw new IllegalArgumentException("Student is already exist");
        }
        subjectsAndGradesByStudents.computeIfAbsent(student, k -> subjects);
    }

    public void addSubjectAndGradeForExistingStudent(Student student, Subject subject, int grade) {
        subjectsAndGradesByStudents.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }

    public void deleteStudentWithSubjectsAndGrades(Student student) {
        subjectsAndGradesByStudents.remove(student);
    }

    public void printAllStudentsWithSubjectsAndGrades() {
        for (var entry : subjectsAndGradesByStudents.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (studentsBySubject.containsKey(subject)) {
            throw new IllegalArgumentException("Subject is already exist");
        }
        studentsBySubject.put(subject, students);
    }

    public void addStudentAtExistingSubject(Student student, Subject subject) {
        List<Student> currentStudents = studentsBySubject.get(subject);
        currentStudents.add(student);
    }

    public void deleteStudentAtSubject(Student student, Subject subject) {
        List<Student> currentStudents = studentsBySubject.get(subject);
        currentStudents.remove(student);
    }


    public void printAllSubjectsWithStudents() {
        for (var entry : studentsBySubject.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
