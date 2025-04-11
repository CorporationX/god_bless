package school.faang.bjs2_68745;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentDatabase {
    @Getter
    private final Map<Student, Map<Subject, Integer>> studentSubjects;
    @Getter
    private final Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        this.studentSubjects = new HashMap<>();
        this.subjectStudents = new HashMap<>();
    }

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        studentSubjects.computeIfAbsent(student, studentKey -> new HashMap<>()).putAll(subjects);
        for (Subject subject : studentSubjects.get(student).keySet()) {
            putStudentIntoSubjectStudentsMap(student, subject);
        }
    }

    public void addSubjectToStudent(Student student, Subject subject, Integer grade) {
        studentSubjects.computeIfAbsent(student, studentKey -> new HashMap<>()).put(subject, grade);
        putStudentIntoSubjectStudentsMap(student, subject);
    }

    public void removeStudent(Student student) {
        studentSubjects.remove(student);
        subjectStudents.forEach((subject, students) -> students.remove(student));
    }

    public void printAllStudents() {
        studentSubjects.forEach((student, subjectsMap) -> {
            System.out.printf("Student: %s\n", student.name());
            subjectsMap.forEach((subject, grade)
                -> System.out.printf("\t%s - %d\n", subject.name(), grade));
        });
    }

    public void addSubjectWithStudentList(Subject subject, List<Student> students) {
        for (Student student : students) {
            addStudentToSubjects(student, subject);
        }
    }

    public void addStudentToSubjects(Student student, Subject subject) {
        studentSubjects.computeIfAbsent(student, studentKey -> new HashMap<>()).put(subject, null);
        putStudentIntoSubjectStudentsMap(student, subject);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects != null) {
            subjects.remove(subject);
        }
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
    }

    public void printAllSubject() {
        subjectStudents.forEach((subject, students) -> {
            System.out.printf("Subject: %s\n", subject.name());
            students.forEach(student -> System.out.printf("\tStudent: %s\n", student.name()));
        });
    }

    private void putStudentIntoSubjectStudentsMap(Student student, Subject subject) {
        List<Student> students = subjectStudents.getOrDefault(subject, new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
            subjectStudents.put(subject, students);
        }
    }
}
