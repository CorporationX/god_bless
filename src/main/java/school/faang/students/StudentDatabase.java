package school.faang.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new ConcurrentHashMap<>();
    public final Map<Subject, List<Student>> subjectStudents = new ConcurrentHashMap<>();

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Integer> subjects) {
        studentSubjects.putIfAbsent(student, subjects);
        subjects.keySet().forEach(subject -> subjectStudents
                .computeIfAbsent(subject, k -> new ArrayList<>()).add(student));
    }

    public String addSubjectToExistingStudent(Student student, Subject subject, Integer grade) {
        String message;
        Map<Subject, Integer> subjectsByStudent = studentSubjects.get(student);
        if (subjectsByStudent == null) {
            message = student + " does not exist";
            System.out.println(message);
            return message;
        }

        subjectsByStudent.put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);

        message = subject + " was successfully added to " + student;
        System.out.println(message);
        return message;
    }

    public void deleteStudentAndHisSubjects(Student student) {
        studentSubjects.remove(student);
        subjectStudents.forEach((subject, students) -> students.remove(student));
    }

    public void addSubjectAndListStudents(Subject subject, List<Student> students) {
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>(Map.of(subject, 0)));
        }

        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).addAll(students);
    }

    public String addStudentToExistingSubject(Student student, Subject subject) {
        List<Student> studentsBySubject = subjectStudents.get(subject);
        String message;

        if (studentsBySubject == null || studentsBySubject.isEmpty()) {
            message = subject + " does not exist";
            System.out.println(message);
            return message;
        }

        studentsBySubject.add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);

        message = student + " was successfully added to " + subject;
        System.out.println(message);
        return message;
    }

    public String deleteStudentFromSubject(Student student, Subject subject) {
        String message;
        Map<Subject, Integer> subjectsByStudent = studentSubjects.get(student);
        List<Student> studentsBySubject = subjectStudents.get(subject);

        if (subjectsByStudent == null) {
            message = student + " does not exist";
            System.out.println(message);
            return message;
        }
        if (studentsBySubject == null || studentsBySubject.isEmpty()) {
            message = subject + " does not exist";
            System.out.println(message);
            return message;
        }

        subjectsByStudent.remove(subject);
        studentsBySubject.remove(student);

        message = student + " was successfully deleted from " + subject;
        System.out.println(message);
        return message;
    }

    public Map<Student, Map<Subject, Integer>> printStudents() {
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
