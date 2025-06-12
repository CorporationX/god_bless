package school.faang.bjs2_79750;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@NoArgsConstructor
@Data
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentAndSubjectsWithGrades(Student student, Map<Subject, Integer> subjectsWithGrades) {
        studentSubjects.put(student, subjectsWithGrades);
        for (Subject subject : subjectsWithGrades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectWithGrade(Student student, Subject subject, Integer grade) {
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> subjectsWithGrades = studentSubjects.remove(student);
        if (subjectsWithGrades != null) {
            for (Subject subject : subjectsWithGrades.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
    }

    public void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            log.info("Студент: {}", entry.getKey().name());
            log.info("Предметы и оценки:");
            for (Map.Entry<Subject, Integer> subjectEntry : entry.getValue().entrySet()) {
                log.info("Предмет: {}, Оценка: {}", subjectEntry.getKey().name(), subjectEntry.getValue());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));

        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());

        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }

        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);

        if (students != null) {
            students.remove(student);
        }

        Map<Subject, Integer> grades = studentSubjects.get(student);

        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            log.info("Предмет: {}", entry.getKey().name());
            log.info("Студенты: {}", entry.getValue().toString());
        }
    }
}
