package school.faang.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static school.faang.students.Grade.NOT_GRADED;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Grade>> studentSubjects = new ConcurrentHashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new ConcurrentHashMap<>();

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Grade> subjects) {
        studentSubjects.putIfAbsent(student, subjects);
        subjects.keySet().forEach(subject -> subjectStudents
                .computeIfAbsent(subject, k -> new ArrayList<>()).add(student));
    }

    public void addSubjectToExistingStudent(Student student, Subject subject, Grade grade) {
        Map<Subject, Grade> subjectsByStudent = studentSubjects.get(student);
        if (subjectsByStudent == null) {
            throw new StudentException();
        }

        subjectsByStudent.put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void deleteStudentAndHisSubjects(Student student) {
        studentSubjects.remove(student);
        subjectStudents.forEach((subject, students) -> students.remove(student));
    }

    public void addSubjectAndListStudents(Subject subject, List<Student> students) {
        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, NOT_GRADED);
        }

        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).addAll(students);
    }

    public void addStudentToExistingSubject(Student student, Subject subject) {
        List<Student> studentsBySubject = subjectStudents.get(subject);

        if (studentsBySubject == null || studentsBySubject.isEmpty()) {
            throw new StudentException();
        }

        studentsBySubject.add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, NOT_GRADED);
    }

    public void deleteStudentFromSubject(Student student, Subject subject) {
        Map<Subject, Grade> subjectsByStudent = studentSubjects.get(student);
        List<Student> studentsBySubject = subjectStudents.get(subject);

        if (subjectsByStudent == null || studentsBySubject == null || studentsBySubject.isEmpty()) {
            throw new StudentException();
        }

        subjectsByStudent.remove(subject);
        studentsBySubject.remove(student);
    }

    public Map<Student, Map<Subject, Grade>> printStudents() {
        studentSubjects.forEach((student, subjects) -> System.out.println(
                student + " " + subjects
        ));
        return studentSubjects;
    }

    public Map<Subject, List<Student>> printSubjects() {
        subjectStudents.forEach((subject, students) -> System.out.println(
                subject + " " + students
        ));
        return subjectStudents;
    }


}
