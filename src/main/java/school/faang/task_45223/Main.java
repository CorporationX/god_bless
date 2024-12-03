package school.faang.task_45223;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        Student ben = new Student(1, "Ben");
        Student max = new Student(2, "Max");
        Subject math = new Subject(1, "math");
        Map<Subject, Integer> map = new HashMap<>();
        map.put(math, 5);
        studentDatabase.addStudentWithSubjects(ben, map);
        studentDatabase.addStudentWithSubjects(max, map);
        Subject physic = new Subject(2, "physic");
        studentDatabase.addNewSubjectToExistStudent(ben, physic, 5);
        studentDatabase.printStudentGrades();
        Subject history = new Subject(3, "history");
        studentDatabase.addNewSubjectAndListStudents(history, List.of(max, ben));
        studentDatabase.printStudentGrades();
        studentDatabase.printSubjects();
        Student jane = new Student(3, "Jane");
        studentDatabase.addStudentToExistsSubject(math, jane);
        studentDatabase.printStudentGrades();
        studentDatabase.printSubjects();
        studentDatabase.removeStudentFromSubject(math, ben);
        studentDatabase.printStudentGrades();
        studentDatabase.printSubjects();
    }
}