package faang.school.godbless.bjs220100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Student, Map<Subject, Integer>> subjectsAndGradesByStudent = new HashMap<>();
        Map<Subject, List<Student>> studentsBySubject = new HashMap<>();
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Dude");
        Subject subject1 = new Subject(1, "Biology");
        Subject subject2 = new Subject(2, "Mathematics");
        StudentSubjectService studentSubjectService = new StudentSubjectService();

        studentSubjectService.addStudentsGrade(subjectsAndGradesByStudent, student1, subject1, 9);
        studentSubjectService.addStudentsGrade(subjectsAndGradesByStudent, student1, subject2, 7);
        studentSubjectService.addStudentsGrade(subjectsAndGradesByStudent, student2, subject2, 8);
        studentSubjectService.printStudentsGrades(subjectsAndGradesByStudent);

        studentSubjectService.addSubjectAndStudent(studentsBySubject, subject1, student1);
        studentSubjectService.addSubjectAndStudent(studentsBySubject, subject2, student1);
        studentSubjectService.addSubjectAndStudent(studentsBySubject, subject2, student2);
        studentSubjectService.printSubjectsAndStudents(studentsBySubject);
    }
}
