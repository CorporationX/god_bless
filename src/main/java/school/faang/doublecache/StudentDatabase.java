package school.faang.doublecache;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@ToString
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects;
    private Map<Subject, List<Student>> subjectStudents;

    public void addStudentWithGrades(Student student, Map<Subject, Integer> studentsGrades) {
        studentSubjects.putIfAbsent(student, studentsGrades);
        for (Subject subject : studentsGrades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addNewSubjectToStudent(Student student, Subject subjectName, Integer grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subjectName, grade);

        subjectStudents.computeIfAbsent(subjectName, k -> new ArrayList<>()).add(student);
    }

    public void deleteStudent(Student student) {
        Map<Subject, Integer> removedGrades = studentSubjects.remove(student);

        for (Subject subject : removedGrades.keySet()) {
            List<Student> students = subjectStudents.get(subject);
            if (students != null) {
                students.remove(student);
            }
        }
    }

    public void printAllStudentsWithGrades() {
        studentSubjects.forEach(((student, subjectGrade) -> {
            log.info("Student - {}", student.getName());
            subjectGrade.forEach((subject, grade) ->
                    log.info("{} - {}", subject.getName(), grade)
            );
        }));
    }

    public void addNewSubjectAndStudents(Subject subject, List<Student> students) {
        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>())
                    .putIfAbsent(subject, null);
        }
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>())
                .addAll(students);
    }

    public void addStudentToSubject(Student student, Subject subject) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>())
                .putIfAbsent(subject, null);

        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void deleteStudentFromSubject(Subject subject, Student student) {
        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects != null && !subjects.isEmpty()) {
            subjects.remove(subject);
        }

        List<Student> students = subjectStudents.get(subject);
        if ((students != null && !students.isEmpty())) {
            students.remove(student);
        }
    }

    public void printAllSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            log.info("Subject: {}", subject.getName());
            students.forEach(s -> log.info("Students - {}", s.getName()));
        });
    }


}
