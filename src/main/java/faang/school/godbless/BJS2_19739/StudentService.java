package faang.school.godbless.BJS2_19739;

import lombok.Getter;

import java.util.Map;

@Getter
public class StudentService {

    private final Map<Student, Map<Subject, Integer>> students;

    public StudentService(Map<Student, Map<Subject, Integer>> students) {
        this.students = students;
    }

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        if (students.containsKey(student)) {
            students.get(student).putAll(subjects);
        }else {
            students.put(student, subjects);
        }
    }

    public void addSubject(Student student, Subject subject, int grade) {
        if (!students.containsKey(student)) {
            throw new IllegalArgumentException("Student does not exist");
        }
        students.get(student).put(subject, grade);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void printStudents() {
        students.forEach((student, subjects) -> {
            System.out.println(student + ": ");
            subjects.forEach((subject, grade) -> System.out.println(subject + ": " + grade));
        });
    }

}
