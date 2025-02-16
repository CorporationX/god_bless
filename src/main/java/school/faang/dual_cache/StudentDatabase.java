package school.faang.dual_cache;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects;
    private final Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        studentSubjects = new HashMap<Student, Map<Subject, Integer>>();
        subjectStudents = new HashMap<Subject, List<Student>>();
    }

    public void addNewStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        if (student == null || grades == null) {
            throw new IllegalArgumentException("Input data must not be null");
        }
        studentSubjects.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            if (!subjectStudents.get(subject).contains(student)) {
                subjectStudents.get(subject).add(student);
            }
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Input data must not be null");
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Input data must not be null");
        }
        for (List<Student> list : subjectStudents.values()) {
            if (list != null) {
                list.remove(student);
            }
        }
        studentSubjects.remove(student);
    }

    public void printAllStudentsWithSubjectsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            Student student = entry.getKey();
            var value = entry.getValue();
            System.out.println(student.getName());
            for (Map.Entry<Subject, Integer> entry1 : value.entrySet()) {
                Subject subject = entry1.getKey();
                StringBuilder stringBuilder = new StringBuilder("--- ").append(subject.getName()).append(": ")
                                .append(entry1.getValue());
                System.out.println(stringBuilder);
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject == null || students == null) {
            throw new IllegalArgumentException("Input data must not be null");
        }
        subjectStudents.putIfAbsent(subject, new ArrayList<>(students));
        for (var student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        if (subject == null || subject == null) {
            throw new IllegalArgumentException("Input data must not be null");
        }

        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }

        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Input data must not be null");
        }

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
        subjectStudents.forEach((k, v) -> {
            System.out.println(k.getName());
            v.forEach(s ->
                    System.out.println(new StringBuilder("----").append(s.getName())));
        });
    }
}
