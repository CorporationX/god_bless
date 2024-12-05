package school.faang.task_45214.util;

import school.faang.task_45214.model.Student;
import school.faang.task_45214.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> students;
    Map<Subject, List<Student>> subjects;

    public StudentDatabase(Map<Student, Map<Subject, Integer>> students, Map<Subject, List<Student>> subjects) {
        this.students = students;
        this.subjects = subjects;
    }

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        students.put(student, subjects);

        for (Subject subject : subjects.keySet()) {
            this.subjects.computeIfAbsent(subject, s -> new ArrayList<>())
                    .add(student);
        }
    }

    public void addSubjectWithStudent(Student student, Subject subjectNew, Integer score) {
        students.computeIfAbsent(student, p -> new HashMap<>())
                .put(subjectNew, score);
        subjects.computeIfAbsent(subjectNew, s -> new ArrayList<>())
                .add(student);
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjects.computeIfAbsent(subject, s -> new ArrayList<>())
                .addAll(students);

        for (Student student : students) {
            this.students.computeIfAbsent(student, s -> new HashMap<>())
                    .put(subject, 0);
        }
    }

    public void deleteStudentWithSubjects(Student student) {
        Map<Subject, Integer> grades = students.remove(student);

        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                List<Student> studentsFromSubjects = this.subjects.get(subject);
                if (studentsFromSubjects != null) {
                    studentsFromSubjects.remove(student);
                }
            }
        }
    }

    public void deleteStudentFromSubjects(Subject subject, Student student) {
        var grades = students.get(student);

        if (grades != null) {
            grades.remove(subject);
        }

        if (subjects.containsKey(subject)) {
            subjects.get(subject).remove(student);
        }
    }

    public void printAllStudentsWithSubjectsAndScores() {
        students.forEach((student, subjectsWithGrades) ->
                subjectsWithGrades.forEach((subject, grade) ->
                        System.out.printf("student: %s, subject: %s, score: %d%n", student, subject, grade)
                )
        );
    }

    public void printAllSubjectsWithStudents() {
        subjects.forEach((subject, grades) ->
                grades.forEach(student ->
                        System.out.printf("Subject: %s, student: %s%n", subject, student)
                )
        );
    }
}
