package school.faang.double_cash_cash;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects;

    private Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        studentSubjects = new HashMap<>();
        subjectStudents = new HashMap<>();
    }

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        Objects.requireNonNull(student);
        Objects.requireNonNull(subjects);

        if (studentSubjects.containsKey(student)) {
            System.out.printf("student: \"%s\" is already exists\n", student.getName());
            return;
        }

        studentSubjects.put(student, subjects);

        for (Map.Entry<Subject, Integer> entry : subjects.entrySet()) {
            subjectStudents.putIfAbsent(entry.getKey(), new ArrayList<>());
            List<Student> students = subjectStudents.get(entry.getKey());
            if (!students.contains(student)) {
                students.add(student);
            }
        }

        System.out.printf("student: \"%s\" has been successfully added\n", student.getName());
    }

    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        Objects.requireNonNull(student);
        Objects.requireNonNull(subject);
        Objects.requireNonNull(grade);

        Map<Subject, Integer> subjects = studentSubjects.computeIfAbsent(student, s -> new HashMap<>());
        if (subjects.containsKey(subject)) {
            System.out.printf("student: \"%s\" already has the subject: \"%s\"\n",
                    student.getName(), subject.getName());
            return;
        }

        subjects.put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        List<Student> students = subjectStudents.get(subject);
        if (!students.contains(student)) {
            students.add(student);
        }
        System.out.printf("student: \"%s\" successfully added the subject: \"%s\"\n",
                student.getName(), subject.getName());
    }

    public void removeStudent(Student student) {
        Objects.requireNonNull(student);

        if (!studentSubjects.containsKey(student)) {
            System.out.printf("student: \"%s\" is not in the database\n", student.getName());
            return;
        }

        studentSubjects.remove(student);
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            entry.getValue().remove(student);
        }
        System.out.printf("student: \"%s\" has been successfully removed\n", student.getName());
    }

    public void printAllStudents() {
        System.out.println("Students Info");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.println("-----------------------------");
            System.out.printf("-student name: \"%s\", subjects:\n", entry.getKey().getName());
            for (Map.Entry<Subject, Integer> subjectEntry : entry.getValue().entrySet()) {
                System.out.printf("---subject: \"%s\" grade: \"%d\"\n",
                        subjectEntry.getKey().getName(), subjectEntry.getValue());
            }
            System.out.println("-----------------------------");
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        Objects.requireNonNull(subject);
        Objects.requireNonNull(students);

        if (subjectStudents.containsKey(subject)) {
            System.out.printf("subject: \"%s\" already exists\n", subject.getName());
            return;
        }

        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            Map<Subject, Integer> map = studentSubjects.get(student);
            map.putIfAbsent(subject, 0);
        }

        System.out.printf("subject: \"%s\" has been added\n", subject.getName());
    }

    public void addStudentToSubject(Subject subject, Student student, int grade) {
        studentSubjects.putIfAbsent(student, new HashMap<>());
        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects.containsKey(subject)) {
            System.out.printf("student: \"%s\" already has subject: \"%s\"\n", student.getName(), subject.getName());
            return;
        }

        subjects.put(subject, grade);
        subjectStudents.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
        System.out.printf("student: \"%s\" has been added an subject: \"%s\"\n", student.getName(), subject.getName());
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        if (!studentSubjects.containsKey(student)) {
            System.out.printf("student: \"%s\" is not in the database\n", student.getName());
            return;
        }

        if (!subjectStudents.containsKey(subject)) {
            System.out.printf("subject: \"%s\" is not in the database\n", subject.getName());
            return;
        }

        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        List<Student> students = subjectStudents.get(subject);
        if (!students.contains(student)) {
            System.out.printf("student: \"%s\" is not enrolled in subject: \"%s\"\n",
                    student.getName(), subject.getName());
            return;
        }

        students.remove(student);
        System.out.printf("student: \"%s\" s successfully removed from subject: \"%s\"\n",
                student.getName(), subject.getName());
    }

    public void printAllSubjects() {
        System.out.println("Subjects Info");
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("-----------------------------");
            System.out.printf("-subject: \"%s\"\n", entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.printf("---student name: \"%s\"\n", student.getName());
            }
            System.out.println("-----------------------------");
        }
    }
}
