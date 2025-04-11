package school.faang.collection.cash;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
@Getter
public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public StudentDatabase addStudent(Student student, Map<Subject, Integer> diary) {
        addStudentDiary(student, diary);
        diary
                .keySet()
                .forEach(subject ->
                        addStudentToSubject(subject, student)
                );
        return this;
    }

    public StudentDatabase addNewSubjectToStudent(Student student, Subject subject, Integer rating) {
        addStudentSubject(student, subject, rating);
        addStudentToSubject(subject, student);
        return this;
    }

    public StudentDatabase removeStudent(Student student) {
        Map<Subject, Integer> studentDiary = getDiary(student);
        studentDiary
                .keySet()
                .forEach(subject -> getSubjectStudents(subject).remove(student));
        return this;
    }

    public StudentDatabase printStudentRating() {
        studentSubjects.forEach((student, diary) -> {
                    log.info("Оценки {}:", student);
                    diary.forEach((subject, rating) -> log.info("{} - {}", subject, rating));
                }
        );
        return this;
    }

    public StudentDatabase addSubjectStudents(Subject subject, Map<Student, Integer> studentDiaries) {
        addStudentToSubject(subject, studentDiaries.keySet().stream().toList());
        studentDiaries.forEach((student, rating) -> addNewSubjectToStudent(student, subject, rating));
        return this;
    }

    public StudentDatabase addStudentToSubject(Subject subject, Student student, Integer rating) {
        addStudentToSubject(subject, student);
        addStudentSubject(student, subject, rating);
        return this;
    }

    public StudentDatabase removeStudentFromSubject(Subject subject, Student student) {
        getDiary(student).remove(subject);
        getSubjectStudents(subject).remove(student);
        return this;
    }

    public StudentDatabase printSubjectStudents() {
        subjectStudents.forEach((subject, students) ->
                log.info("На предмете {} обучаются - {}", subject, students));
        return this;
    }

    private void addStudentSubject(Student student, Subject subject, Integer rating) {
        studentSubjects.computeIfAbsent(student, newStudent -> new HashMap<>()).put(subject, rating);
    }

    private void addStudentDiary(Student student, Map<Subject, Integer> diary) {
        studentSubjects.computeIfAbsent(student, newStudent -> new HashMap<>()).putAll(diary);
    }

    private Map<Subject, Integer> getDiary(Student student) {
        var studentDiary = studentSubjects.get(student);
        if (studentDiary == null) {
            throw new NoSuchElementException("Student %s not found!".formatted(student));
        }
        return studentDiary;
    }

    private void addStudentToSubject(Subject subject, Student student) {
        subjectStudents.computeIfAbsent(subject, newSubject -> new ArrayList<>()).add(student);
    }

    private void addStudentToSubject(Subject subject, List<Student> students) {
        subjectStudents.computeIfAbsent(subject, newSubject -> new ArrayList<>()).addAll(students);
    }

    private List<Student> getSubjectStudents(Subject subject) {
        var students = subjectStudents.get(subject);
        if (students == null) {
            throw new NoSuchElementException("Subject %s not found!".formatted(subject));
        }
        return students;
    }
}
