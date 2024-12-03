package school.faang.task_45223;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        Student ben = new Student(1, "Ben");
        Student max = new Student(2, "Max");
        Student jane = new Student(3, "Jane");
        Subject math = new Subject(1, "math");
        Subject physic = new Subject(2, "physic");
        Subject history = new Subject(3, "history");
        Map<Subject, Integer> map = new HashMap<>();
        map.put(math, 5);
        studentDatabase.addStudentWithSubjects(ben, map);
        studentDatabase.addStudentWithSubjects(max, map);
        studentDatabase.addNewSubjectToExistStudent(ben, physic, 5);
        studentDatabase.printStudentGrades();
        studentDatabase.addNewSubjectAndListStudents(history, List.of(max, ben));
        studentDatabase.printStudentGrades();
        studentDatabase.printSubjects();
        studentDatabase.addStudentToExistsSubject(math, jane);
        studentDatabase.printStudentGrades();
        studentDatabase.printSubjects();
        studentDatabase.removeStudentFromSubject(math, ben);
        studentDatabase.printStudentGrades();
        studentDatabase.printSubjects();
    }
}