package school.faang.double_cache_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    public void addNewSubjectToStudent(String subjectName, Student student) {
        Objects.requireNonNull(subjectName, "subject is null");

        Subject subject = new Subject(subjectName);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubject.computeIfAbsent(student, k -> new HashMap<>()).putIfAbsent(subject, null);
    }

    public void deleteAllStudentInfo(String name) {
        Student student = new Student(name);
        studentSubject.remove(student);
        subjectStudents.values().forEach(studensList -> studensList.remove(student));
    }

    public void showAllStudentsInfo() {
        System.out.println("Students and their subjects:");
        studentSubject.forEach((student, subjectsMap) -> {
            System.out.println("• " + student + ":");
            subjectsMap.forEach((subject, mark) -> {
                System.out.printf("   - %s: %d\n", subject, mark);
            });
        });
    }

    public void addNewSubjectAndListOfStudents(String subjectsName, List<Student> students) {
        Objects.requireNonNull(subjectsName, "subjects is null");
        Objects.requireNonNull(students, "students is null");

        Subject subject = new Subject(subjectsName);
        subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>()).addAll(students);
        for (Student student : students) {
            studentSubject.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubject.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
    }

    public void deleteStudentFromSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).remove(student);
        studentSubject.computeIfAbsent(student, k -> new HashMap<>()).remove(subject);
    }

    public void showAllSubjectsAndStudents() {
        System.out.println("Subjects and students on them:");
        subjectStudents.forEach((subject, students) -> {
            System.out.print("• " + subject + ": ");
            String joined = students.stream()
                    .map(Student::getName)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("—");
            System.out.println(joined);
        });
    }

}
