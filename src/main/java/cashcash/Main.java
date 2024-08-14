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
        Student max = new Student(0, "max");
        Map<Subject, Integer> maxMark = new HashMap<>();
        maxMark.put(new Subject(0, "english"), 4);
        maxMark.put(new Subject(1, "Math"), 5);
        maxMark.put(new Subject(2, "History"), 2);
        maxMark.put(new Subject(3, "Minecraft"), 10);

        Student.addStudent(studentsBySubjects, max, maxMark);
        Student.addSubject(studentsBySubjects, max, new Subject(4, "Chemical"), 4);
        Student.outputStudent(studentsBySubjects);
        Student.removeStudent(studentsBySubjects, max);
        Student.outputStudent(studentsBySubjects);

        Map<Subject, List<Student>> subjectsByStudents = new HashMap<>();
        Student mark = new Student(2, "mark");
        Subject english =  new Subject(0, "english");
        List<Student> studentList = new ArrayList<>();
        studentList.add(max);
        studentList.add(new Student(1, "John"));
        studentList.add(mark);
        studentList.add(new Student(3, "Georg"));

        Subject.addSubject(subjectsByStudents, english, studentList);
        Subject.addStudentToSubjectList(subjectsByStudents, new Student(4, "Anna"), english);
        Subject.removeStudentFromSubjectList(subjectsByStudents, mark, english);
        Subject.outputAllSubjects(subjectsByStudents);

    }
}
