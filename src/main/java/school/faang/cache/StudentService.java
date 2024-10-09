package school.faang.cache;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class StudentService {

    private final Map<Student, Map<Subject, Integer>> students;
    private final Map<Subject, List<Student>> subjects;

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        students.put(student, subjects);
        subjects.forEach((k, v) -> this.subjects.computeIfAbsent(k, s -> new ArrayList<>()).add(student));
    }

    public void addSubjectAndGrade(Student student, Subject subject, int grade) {
        students.get(student).put(subject, grade);
        subjects.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        subjects.forEach((k, v) -> v.remove(student));
        subjects.values().removeIf(List::isEmpty);
    }

    public void printAllStudents() {
        students.forEach((k, v) -> {
            System.out.printf("Student %s id %d: \n", k.getName(), k.getId());
            v.forEach((k1, v1) -> System.out.printf("%s grade: %d \n", k1.getName(), v1));
            System.out.println();
        });
    }

    public void addSubject(Subject subject, List<Student> students) {
        students.forEach(student -> {
            subjects.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
            this.students.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        });
    }

    public void addStudentToSubject(Subject subject, Student student, int grade){
        subjects.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
        students.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }

    public void removeStudentFromSubject(Subject subject, Student student){
        subjects.get(subject).remove(student);
        subjects.values().removeIf(List::isEmpty);

        students.forEach((k, v) -> v.remove(subject));
    }

    public void printAllSubjects() {
        subjects.forEach((k, v) -> {
            System.out.printf("Subject %s id %d: \n", k.getName(), k.getId());
            v.forEach(student ->
                    System.out.printf("Student %s, id %d\n", student.getName(), student.getId()));
            System.out.println();
        });
    }
}
