package school.student_subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addNewSubjectForStudents(Subject subject, List<Student> students) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>())
                .addAll(students);

        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>())
                    .putIfAbsent(subject, 0);
        }
    }

    public void addOldSubjectForStudents(Subject subject, Student student) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>())
                .putIfAbsent(subject, 0);
    }

    public void removeStudentFromSubjects(Student student, Subject subject) {
        Optional.ofNullable(studentSubjects.get(student))
                .ifPresent(subjects -> subjects.remove(subject));
        Optional.ofNullable(subjectStudents.get(subject))
                .ifPresent(students -> students.remove(student));
    }

    public void printSubjectsAndLearningStudents() {
        subjectStudents.forEach((subject, students) ->
                System.out.println(subject + ": " + students));
    }

    public void addStudentsWithSubjectsAndMarks(Student student, Map<Subject, Integer> subjects) {
        // Создаем новую изменяемую HashMap на основе переданных subjects
        Map<Subject, Integer> mutableSubjects = new HashMap<>(subjects);
        studentSubjects.put(student, mutableSubjects);

        for (Map.Entry<Subject, Integer> entry : mutableSubjects.entrySet()) {
            subjectStudents.computeIfAbsent(entry.getKey(), k -> new ArrayList<>())
                    .add(student);
        }
    }

    public void addNewSubjectForStudentWithMark(Student student, Subject subject, int mark) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>())
                .put(subject, mark);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>())
                .add(student);
    }

    public void removeStudentAndHisSubjects(Student student) {
        // Получаем все предметы студента
        Map<Subject, Integer> subjects = studentSubjects.remove(student);
        if (subjects != null) {
            // Удаляем студента из всех его предметов
            for (Subject subject : subjects.keySet()) {
                Optional.ofNullable(subjectStudents.get(subject))
                        .ifPresent(students -> students.remove(student));
            }
        }
    }

    public void printAllStudents() {
        studentSubjects.forEach((student, subjects) ->
                subjects.forEach((subject, mark) ->
                        System.out.println(student + " " + subject + " " + mark)));
    }
}
