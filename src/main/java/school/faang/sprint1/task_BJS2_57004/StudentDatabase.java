package school.faang.sprint1.task_BJS2_57004;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects;
    private Map<Subject, List<Student>> subjectStudents;

    /**
     * Добавляет в базу студента с его предметами и их оценками
     * Если студент уже существует, то добавляет ему предметы и их оценки
     * Если у студента уже есть такие предметы то оценки обновятся на новые
     *
     * @param name не может быть null или пустым
     *             если {@param name} null или пустым будет выброшено исключение IllegalArgumentException
     * @param subjectsWithRatings не может быть null или пустым
     *             если {@param subjectsWithRatings} null или пустым будет выброшено исключение IllegalArgumentException
     */

    public void addStudent(String name, Map<Subject, Integer> subjectsWithRatings) {
        Student student = new Student(name);
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).putAll(subjectsWithRatings);
        } else {
            studentSubjects.put(student, subjectsWithRatings);
        }

        subjectsWithRatings.forEach((subject, ratings) -> {
            subjectStudents.computeIfAbsent(subject, s -> new ArrayList<>());

        });

    }

    public void addSubjectToStudent(Subject subject, Student student, int rating) {

    }

    public void removeStudent(Student student) {

    }

    public void printStudentInfo() {

    }

    public void addNewSubject(Subject subject, List<Student> students) {

    }

    public void addStudentToSubject(Subject subject, Student student) {

    }

    public void removeStudentFromSubject(Subject subject, Student student) {

    }

    public void printSubjectsWithStudents() {

    }
}
