package school.faang.task_57052;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> subjectGrades) {
        studentSubjects.putIfAbsent(student, subjectGrades);
        for (Subject subject : subjectGrades.keySet()) {
            subjectStudents.putIfAbsent(subject, new HashSet<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectGrades(Student student, Subject subject, int grade) {
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new HashSet<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentSubjects.remove(student);
        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                Set<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
    }

    public void printAllStudentsWithGrades() {
        for (var entry : studentSubjects.entrySet()) {
            Map<Subject, Integer> grades = entry.getValue();
            System.out.println("Студент: " + entry.getKey().getName());
            grades.forEach((subject, grade) -> System.out.printf("- Предмет: %s, Оценка: %d\n",
                    subject.getName(), grade));
            System.out.println();
        }
    }

    public void addSubjectWithStudents(Subject subject, Set<Student> students) {
        subjectStudents.put(subject, new HashSet<>(students));
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new HashSet<>());
        subjectStudents.get(subject).add(student);
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        Set<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubjectsWithStudents() {
        for (var entry : subjectStudents.entrySet()) {
            Set<Student> students = entry.getValue();
            System.out.println("Предмет: " + entry.getKey().getName());
            students.forEach(student -> System.out.printf("- Студент: %s\n", student.getName()));
            System.out.println();
        }
    }
}
