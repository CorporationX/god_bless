package cashcash;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class Main {
    public static void main(String[] args) {
        Map<Student, Map<Subject, Integer>> studentsBySubjects = new HashMap<>();
        Student Max = new Student(0, "Max");
        Map<Subject, Integer> maxMark = new HashMap<>();
        maxMark.put(new Subject(0, "English"), 4);
        maxMark.put(new Subject(1, "Math"), 5);
        maxMark.put(new Subject(2, "History"), 2);
        maxMark.put(new Subject(3, "Minecraft"), 10);

        Student.addStudent(studentsBySubjects, Max, maxMark);
        Student.addSubject(studentsBySubjects, Max, new Subject(4, "Chemical"), 4);
        Student.outputStudent(studentsBySubjects);
        Student.removeStudent(studentsBySubjects, Max);
        Student.outputStudent(studentsBySubjects);

        Map<Subject, List<Student>> subjectsByStudents = new HashMap<>();
        Student Mark = new Student(2, "Mark");
        Subject English =  new Subject(0, "English");
        List<Student> studentList = new ArrayList<>();
        studentList.add(Max);
        studentList.add(new Student(1, "John"));
        studentList.add(Mark);
        studentList.add(new Student(3, "Georg"));

        Subject.addSubject(subjectsByStudents, English, studentList);
        Subject.addStudentToSubjectList(subjectsByStudents, new Student(4, "Anna"), English);
        Subject.removeStudentFromSubjectList(subjectsByStudents, Mark, English);
        Subject.outputAllSubjects(subjectsByStudents);

    }
}
