package school.faang.doubleHash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Student student = new Student("Oleg");
        Subject subject = new Subject("Fisika");
        Student studentIgor = new Student("Igor");
        Subject subjectFisra = new Subject("Fisra");

        Map<Subject, Integer> subjectIntegerMap = new HashMap<>();
        subjectIntegerMap.put(subject, 5);

        StudentDatabase studentDatabase = new StudentDatabase();

        studentDatabase.addStudentWithSubject(student, subjectIntegerMap);
        studentDatabase.addSubjectForExistingStudent(studentIgor, subjectFisra, 4);
        studentDatabase.deleteStudent(student);
        studentDatabase.printStudentWithGrade();

        Student studentOlga = new Student("Olga");
        Student studentMisha = new Student("Misha");
        List<Student> studentList = List.of(studentOlga, studentMisha);
        Subject subjectHistory = new Subject("History");
        Subject subjectBiology = new Subject("Biology");
        studentDatabase.addSubjectAndStudent(subjectHistory, studentList);
        studentDatabase.addSubjectExistingStudent(subjectBiology, studentOlga);
        //studentDatabase.deleteStudentFromSubject(studentMisha, subjectHistory);
        studentDatabase.printSubjectAndStudent();
    }
}
