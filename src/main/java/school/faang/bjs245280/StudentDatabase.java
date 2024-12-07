package school.faang.bjs245280;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentDatabase {
    private static final String TEMPLATE_PRINT_INFO_ALL = "Student: %s, subject: %s, assessment: %s";
    private static final String TEMPLATE_PRINT_SUBJECTS = "Subject: %s, student: %s";
    private int countIdStudent;
    private int countIdSubject;
    @NonNull
    private final Map<Student, Map<Subject, Integer>> subjectGradleByStudent;
    @NonNull
    private final Map<Subject, List<Student>> studentBySubject;

    public void addStudentSubjectGrades(Student student, Map<Subject, Integer> grades) {
        this.subjectGradleByStudent.put(student, grades);
        Iterator var3 = grades.keySet().iterator();

        while (var3.hasNext()) {
            Subject subject = (Subject) var3.next();
            this.studentBySubject.putIfAbsent(subject, new ArrayList());
            ((List) this.studentBySubject.get(subject)).add(student);
        }

    }

    public void addSubjectForStudent(String nameSubject, Student student, int grade) {
        if (this.subjectGradleByStudent.containsKey(student)) {
            Subject subject = this.addSubject(nameSubject);
            Map<Subject, Integer> gradeBySubject = (Map) this.subjectGradleByStudent.get(student);
            gradeBySubject.put(subject, grade);
        }

    }

    public void deleteStudentSubject(Student student) {
        Map<Subject, Integer> grades = (Map) this.subjectGradleByStudent.remove(student);
        if (grades != null) {
            Iterator var3 = grades.keySet().iterator();

            while (var3.hasNext()) {
                Subject subject = (Subject) var3.next();
                List<Student> students = (List) this.studentBySubject.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }

    }

    public void printStudentSubjectGrade() {
        this.subjectGradleByStudent.forEach((student, gradeBySubject) -> {
            gradeBySubject.forEach((subject, grade) -> {
                System.out.println(String.format(TEMPLATE_PRINT_INFO_ALL, student, subject, grade));
            });
        });
    }

    public void addSubjectStudents(Subject subject, List<Student> students) {
        this.studentBySubject.put(subject, students);
    }

    public void addStudentsForSubject(Subject subject, Student student) {
        if (this.studentBySubject.containsKey(subject)) {
            List<Student> students = studentBySubject.get(subject);
            students.add(student);
        } else {
            System.out.println("Error! The subject was not found!" + subject);
        }

    }

    public void deleteStudentsFromSubject(Subject subject, Student student) {
        if (this.studentBySubject.containsKey(subject)) {
            List<Student> students = studentBySubject.get(subject);
            students.remove(student);
        } else {
            System.out.println("Error! The subject was not found!" + subject);
        }

    }

    public void printStudentSubject() {
        this.studentBySubject.forEach((subject, students) -> {
            students.forEach((student) -> {
                System.out.println(String.format(TEMPLATE_PRINT_SUBJECTS, subject, student));
            });
        });
    }

    public Student addStudent(String name) {
        ++countIdStudent;
        Student student = new Student(countIdStudent, name);
        this.subjectGradleByStudent.put(student, new HashMap<>());
        return student;
    }

    public Subject addSubject(String name) {
        ++this.countIdSubject;
        Subject subject = new Subject(this.countIdSubject, name);
        this.studentBySubject.put(subject, new ArrayList<>());
        return new Subject(this.countIdSubject, name);
    }

}
