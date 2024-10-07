package school.faang.two.cache;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class School {
    private Map<Student, Map<Subject, Integer>> journal = new HashMap<>();
    private Map<Subject, List<Student>> subjectsWithStudents = new HashMap<>();

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> progress) {
        journal.put(student, progress);
        progress.keySet().forEach(
                subject -> subjectsWithStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student)
        );
    }

    public void addNewSubjectForStudent(Student student, Subject subject, Integer assessment) {
        journal.get(student).put(subject, assessment);
        subjectsWithStudents.computeIfAbsent(subject, newSubject -> new ArrayList<>()).add(student);
    }

    public void deleteStudentWithSubject(Student student) {
        Map<Subject, Integer> removeSubjectsForStudent = journal.remove(student);
        removeSubjectsForStudent.keySet().forEach(
                subject -> subjectsWithStudents.get(subject).remove(student)
        );
    }

    public void printAllStudentsWithSubjects() {
        journal.forEach(
                (student, subjectsWithAssessment) -> {
                    System.out.println("Student: " + student.getName());
                    for (Map.Entry<Subject, Integer> entry : subjectsWithAssessment.entrySet()) {
                        System.out.println(" - " + entry.getKey().getName() + " value: " + entry.getValue());
                    }
                }
        );
    }

    public void addSubjectAndStudents(Subject subject, List<Student> students) {
        subjectsWithStudents.put(subject, students);
    }

    public void addStudentToSubject(Subject subject, Student student) {
        subjectsWithStudents.get(subject).add(student);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        subjectsWithStudents.get(subject).remove(student);
    }

    public void printAllSubjectsWithStudents() {
        subjectsWithStudents.forEach(
                (subject, students) -> {
                    System.out.println("Subject: " + subject);
                    students.forEach(student -> System.out.println(" - " + student));
                }
        );
    }
}
