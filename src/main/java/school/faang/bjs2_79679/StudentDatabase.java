package school.faang.bjs2_79679;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects;
    private Map<Subject, List<Student>> subjectStudents;

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        studentSubjects.put(student, subjects);
        for (Map.Entry<Subject, Integer> subject : subjects.entrySet()) {
            if (subject != null) {
                subjectStudents.computeIfAbsent(subject.getKey(), key -> new ArrayList<>()).add(student);
            }
        }
    }

    public void addSubject(Student student, Subject subject, int grade) {
        if (studentSubjects.get(student) != null) {
            studentSubjects.get(student).put(subject, grade);
        }
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void deleteStudent(Student student) {
        if (studentSubjects.get(student) != null) {
            Map<Subject, Integer> subjects = studentSubjects.get(student);
            studentSubjects.remove(student);
            subjects.forEach((subject, grade) -> subjectStudents.get(subject).remove(student));
        }
    }

    public void printSubject() {
        for (Map.Entry<Subject, List<Student>> subject : subjectStudents.entrySet()) {
            System.out.printf("Предмет: %s%nСтудены: %s%n", subject.getKey().getName(), subject.getValue().toString());
        }
    }
}
