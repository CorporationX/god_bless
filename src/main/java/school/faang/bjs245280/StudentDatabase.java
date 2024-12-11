package school.faang.bjs245280;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class StudentDatabase {
    private static final String TEMPLATE_PRINT_INFO_ALL = "Student: %s, subject: %s, assessment: %s";
    private static final String TEMPLATE_PRINT_SUBJECTS = "Subject: %s, student: %s";
    private int countIdStudent;
    private int countIdSubject;
    @NonNull
    private final Map<Student, Map<Subject, Integer>> subjectGradeByStudent;
    @NonNull
    private final Map<Subject, List<Student>> studentBySubject;

    public void addStudentSubjectGrades(Student student, Map<Subject, Integer> grades) {
        subjectGradeByStudent.put(student, grades);

        for (Subject subject : grades.keySet()) {
            studentBySubject.putIfAbsent(subject, new ArrayList<>());
            studentBySubject.get(subject).add(student);
        }
    }

    public void addSubjectForStudent(String nameSubject, Student student, int grade) {
        if (subjectGradeByStudent.containsKey(student)) {
            Subject subject = this.addSubject(nameSubject);
            Map<Subject, Integer> gradeBySubject = subjectGradeByStudent.get(student);
            gradeBySubject.put(subject, grade);
        } else {
            throw new IllegalStateException("No such student has been found!");
        }
    }

    public void deleteStudentSubject(Student student) {
        Map<Subject, Integer> grades = subjectGradeByStudent.remove(student);

        for (Subject subject : grades.keySet()) {
            List<Student> students = studentBySubject.get(subject);
            if (students != null) {
                students.remove(student);
            }
        }
    }

    public void printStudentSubjectGrade() {
        subjectGradeByStudent.forEach((student, gradeBySubject) -> {
            gradeBySubject.forEach((subject, grade) -> {
                System.out.println(String.format(TEMPLATE_PRINT_INFO_ALL, student, subject, grade));
            });
        });
    }

    public void addSubjectsWithStudents(Subject subject, List<Student> students) {
        studentBySubject.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            addSubjectGradle(subject, student);
        }
    }

    public void addStudentsForSubject(Subject subject, Student student) {
        if (studentBySubject.containsKey(subject)) {
            List<Student> students = studentBySubject.get(subject);
            students.add(student);
            addSubjectGradle(subject, student);
        } else {
            System.out.println("Error! The subject " + subject + ", was not found!");
        }

    }

    public void deleteStudentsFromSubject(Subject subject, Student student) {
        if (studentBySubject.containsKey(subject)) {
            List<Student> students = studentBySubject.get(subject);
            students.remove(student);
        } else {
            System.out.println("Error! The subject " + subject + ", was not found!");
        }

    }

    public void printStudentSubject() {
        this.studentBySubject.forEach((subject, students) -> {
            students.forEach((student) -> {
                System.out.println(String.format(TEMPLATE_PRINT_SUBJECTS, subject, student));
            });
        });
    }

    private void addSubjectGradle(Subject subject, Student student) {
        subjectGradeByStudent.putIfAbsent(student, new HashMap<>());
        subjectGradeByStudent.get(student).put(subject, null);
    }

    public Student addStudent(String name) {
        ++countIdStudent;
        Student student = new Student(countIdStudent, name);
        this.subjectGradeByStudent.put(student, new HashMap<>());
        return student;
    }

    public Subject addSubject(String name) {
        ++countIdSubject;
        Subject subject = new Subject(countIdSubject, name);
        this.studentBySubject.put(subject, new ArrayList<>());
        return new Subject(countIdSubject, name);
    }

}
