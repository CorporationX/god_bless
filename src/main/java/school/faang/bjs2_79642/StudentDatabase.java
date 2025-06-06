package school.faang.bjs2_79642;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        studentSubjects.put(student, subjects);
        for (Subject subject : subjects.keySet()) {
            List<Student> students = subjectStudents.computeIfAbsent(subject, (newSubject) -> new ArrayList<>());
            if (!students.contains(student)) {
                students.add(student);
            }
        }
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        List<Student> students = subjectStudents.computeIfAbsent(subject, (newSubject) -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
        studentSubjects.computeIfAbsent(student, (newStudent) -> new HashMap<>()).put(subject, grade);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> subjects = studentSubjects.remove(student);

        if (subjects != null) {
            for (Subject subject : subjects.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
    }

    public void printAllSubjectsWithStudentsAndGrades() {
        for (var entrySet : subjectStudents.entrySet()) {
            Subject subject = entrySet.getKey();
            System.out.println(subject.name() + ":");

            for (Student student : entrySet.getValue()) {
                Map<Subject, Integer> subjects = studentSubjects.get(student);

                if (subjects != null) {
                    int grade = subjects.get(subject);
                    System.out.println("- " + student.name() + " - " + grade);
                }
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            Map<Subject, Integer> subjects = studentSubjects.computeIfAbsent(student, (newStudent) -> new HashMap<>());
            subjects.putIfAbsent(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.computeIfAbsent(subject, (newSubject) -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
        Map<Subject, Integer> subjects = studentSubjects.computeIfAbsent(student, (newStudent) -> new HashMap<>());
        subjects.putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }

        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects != null) {
            subjects.remove(subject);
        }
    }

    public void printAllSubjectsWithStudents() {
        for (var entrySet : subjectStudents.entrySet()) {
            System.out.println(entrySet.getKey().name() + ":");

            for (Student student : entrySet.getValue()) {
                System.out.println("- " + student.name());
            }
        }
    }
}
