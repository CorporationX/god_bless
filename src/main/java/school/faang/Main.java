package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static school.faang.StudentService.addStudent;
import static school.faang.StudentService.addSubjectsAndGrades;
import static school.faang.StudentService.removeStudent;
import static school.faang.StudentService.viewAllStudents;

public class Main {
    private static Map<Student, Map<Subject, Integer>> subjectsAndGradesMap = new HashMap<>();
    private static Map<Subject, List<Student>> studentSubjectMap = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student(1, "Sergey");
        Student student2 = new Student(2, "Dmitry");
        Subject physics = new Subject(1, "physics");
        Subject math = new Subject(1, "math");
        addStudent(student1, physics, 5, subjectsAndGradesMap, studentSubjectMap);
        addStudent(student2, physics, 4, subjectsAndGradesMap, studentSubjectMap);
        //addSubjectsAndGrades(student1, math, 3, subjectsAndGradesMap);
        removeStudent(student1, subjectsAndGradesMap, studentSubjectMap);
        viewAllStudents(subjectsAndGradesMap, studentSubjectMap);

    }

}
