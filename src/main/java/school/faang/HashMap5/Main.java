package school.faang.HashMap5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.HashMap5.DataBaseService.addListToSubject;
import static school.faang.HashMap5.DataBaseService.addStudentMark;
import static school.faang.HashMap5.DataBaseService.addStudentToSubject;
import static school.faang.HashMap5.DataBaseService.deleteFromSubject;
import static school.faang.HashMap5.DataBaseService.deleteStudent;
import static school.faang.HashMap5.DataBaseService.printStudentsMarks;
import static school.faang.HashMap5.DataBaseService.printStudentsOfSubject;

public class Main {
    public static void main(String[] args) {
        Map<Student, Map<Subject, Integer>> studentMarks = new HashMap<>();
        Map<Subject, List<Student>> studentsOfSubject = new HashMap<>();
        Subject math = new Subject(1, "Mathematics");
        Subject rus = new Subject(2, "Russian language");
        Subject eng = new Subject(3, "English language");
        Subject physics = new Subject(4, "Physics");
        Student student1 = new Student(1, "Alexey");
        Student student2 = new Student(2, "Dmitry");
        Student student3 = new Student(3, "Kirill");
        Student student4 = new Student(4, "Anton");

        addStudentMark(student1, math, 5, studentMarks);
        addStudentMark(student1, rus, 4, studentMarks);
        addStudentMark(student1, eng, 3, studentMarks);
        addStudentMark(student2, math, 5, studentMarks);
        addStudentMark(student2, rus, 5, studentMarks);
        addStudentMark(student2, eng, 5, studentMarks);
        addStudentMark(student3, math, 3, studentMarks);
        addStudentMark(student3, rus, 4, studentMarks);
        addStudentMark(student3, eng, 4, studentMarks);
        addStudentMark(student4, math, 4, studentMarks);
        addStudentMark(student4, rus, 4, studentMarks);
        addStudentMark(student4, eng, 4, studentMarks);
        printStudentsMarks(studentMarks);
        deleteStudent(student4, studentMarks);
        System.out.println("Anton was deleted");
        printStudentsMarks(studentMarks);

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        addListToSubject(physics,list, studentsOfSubject);
        printStudentsOfSubject(studentsOfSubject);
        addStudentToSubject(physics, student4, studentsOfSubject);
        System.out.println("Anton was added to physics");
        printStudentsOfSubject(studentsOfSubject);
        System.out.println("Anton was deleted from physics");
        deleteFromSubject(student4, physics, studentsOfSubject);
        printStudentsOfSubject(studentsOfSubject);
    }
}
