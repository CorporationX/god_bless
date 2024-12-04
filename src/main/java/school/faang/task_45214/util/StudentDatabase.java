package school.faang.task_45214.util;

import school.faang.task_45214.model.Student;
import school.faang.task_45214.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    Map<Student, Map<Subject, Integer>> students;
    Map<Subject, List<Student>> subjects;

    public StudentDatabase(Map<Student, Map<Subject, Integer>> students, Map<Subject, List<Student>> subjects) {
        this.students = students;
        this.subjects = subjects;
    }

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        students.put(student, subjects);
        for (Subject subject : subjects.keySet()) {
            this.subjects.putIfAbsent(subject, new ArrayList<>());
            this.subjects.get(subject).add(student);
        }
    }

    public void addSubjectWithStudent(Student student, Subject subjectNew, Integer score) {
        Map<Subject, Integer> grades = students.get(student);

        if (grades == null) {
            grades = new HashMap<>();
        }

        grades.put(subjectNew, score);
        subjects.putIfAbsent(subjectNew, new ArrayList<>());
        subjects.get(subjectNew).add(student);
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjects.putIfAbsent(subject, new ArrayList<>());
        subjects.get(subject).addAll(students);

        for (Student student : students) {
            this.students.putIfAbsent(student, new HashMap<>());
            this.students.get(student).put(subject, 0);
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
        for (Map.Entry<Student, Map<Subject, Integer>> entry : students.entrySet()) {
            for (Map.Entry<Subject, Integer> subjectEntry : entry.getValue().entrySet()) {
                System.out.println("student: %s, subject: %s, score: %d".formatted(entry.getKey(), subjectEntry.getKey(), subjectEntry.getValue()));
            }
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjects.entrySet()) {
            for (Student student : entry.getValue()) {
                System.out.println("Subject: %s, student: %s".formatted(entry.getKey(), student));
            }
        }
    }
}
