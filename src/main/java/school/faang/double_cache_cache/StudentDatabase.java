package school.faang.double_cache_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubject = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addNewStudentWithSubjectAndMarks(String studentName, List<String> subjectsNames, List<Integer> marks) {
        Objects.requireNonNull(studentName, "student is null");
        Objects.requireNonNull(subjectsNames, "subjects is null");
        Objects.requireNonNull(marks, "marks is null");
        if (subjectsNames.size() != marks.size()) {
            throw new IllegalArgumentException("amount of subjects and marks differ");
        }

        Student student = new Student(studentName);
        Map<Subject, Integer> subjectsMarks = new HashMap<>();
        List<Subject> subjects = subjectsNames.stream()
                .map(Subject::new)
                .collect(Collectors.toList());

        subjectsMarks = IntStream.range(0, subjects.size())
                .boxed()
                .collect(Collectors.toMap(subjects::get, marks::get));

        studentSubject.putIfAbsent(student, subjectsMarks);
        for (Subject subject : subjects) {
            subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
        }
    }

    public void addNewSubjectToStudentWithMark(String subjectName, Student student, Integer mark) {
        Objects.requireNonNull(subjectName, "subject is null");

        Subject subject = new Subject(subjectName);
        Optional.ofNullable(studentSubject.get(student))
                .filter(map -> map.containsValue(mark))
                .ifPresent(map -> map.put(subject, mark));

        subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
    }

    public void deleteAllStudentInfo(Student student) {
        studentSubject.remove(student);
        subjectStudents.remove(subjectStudents.containsValue(student));
    }

    public void showAllStudentsInfo() {
        System.out.println(studentSubject.toString());
    }

    private void addNewSubjectAndListOfStudents(String subject, List<Student> students) {

    }

    private void addStudentToSubject(Student student, Subject subject) {

    }

    private void deleteStudentFromSubject(Student student, Subject subject) {

    }

    private void showAllSubjectsAndStudents() {}

}
