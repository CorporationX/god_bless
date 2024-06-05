package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ServiceStudent serviceStudent = new ServiceStudent();
        ServiceSubject serviceSubject = new ServiceSubject();

        Map<Subject, Integer> subjectWithGrade = new HashMap<>();
        subjectWithGrade.put(new Subject(1, "S1"), 3);
        subjectWithGrade.put(new Subject(2, "S2"), 4);
        subjectWithGrade.put(new Subject(3, "S3"), 5);

        var student = new Student(1, "st1");
        var subject = new Subject(1, "sub1");

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "stu1"));
        students.add(new Student(2, "stu2"));
        students.add(new Student(3, "stu3"));

        var subjectByStudent = serviceStudent.createSubjectByStudent(student, subjectWithGrade);
        serviceStudent.addNewSubjectsToStudent(subjectByStudent, student, new Subject(4, "S4"), 2);
        serviceStudent.printAllStudents(subjectByStudent);
        serviceStudent.removeStudent(subjectByStudent, student);
        System.out.println(subjectByStudent.isEmpty());

        var studentBySubject = serviceSubject.createStudentBySubject(subject, students);
        serviceSubject.printAllSubject(studentBySubject);
        serviceSubject.removeSubject(studentBySubject, subject, student);
        System.out.println(studentBySubject.get(subject).contains(student));
    }
}
