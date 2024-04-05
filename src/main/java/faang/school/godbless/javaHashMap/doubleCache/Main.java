package faang.school.godbless.javaHashMap.doubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        CollegeManager collegeManager = new CollegeManager();

        Student yarik = new Student(2, "Yarik");
        Student denis = new Student(7, "Denis");
        Student danil = new Student(5, "Danil");
        Student elisey = new Student(6, "Elisey");


        System.out.println("College Manager check. \n\nSystem storage at start point:");

        collegeManager.printStudentsInfo();

        System.out.println();

        collegeManager.printSubjectsInfo();

        System.out.println("============================================\n");


        System.out.println("Adding new student (Denis) with his grades.\n");

        Subject computerScience = new Subject(3, "Computer Science");
        Subject physical_education = new Subject(4, "Physical Education");

        Map<Subject, Integer> denisGrades = new HashMap<>();
        denisGrades.put(computerScience, 4);
        denisGrades.put(physical_education, 3);

        collegeManager.addStudentWithGrades(denis, denisGrades);

        System.out.println("System storage at this point:");

        collegeManager.printStudentsInfo();

        System.out.println();

        collegeManager.printSubjectsInfo();

        System.out.println("============================================\n");


        System.out.println("Adding new grades for Yarik (Computer Science and English)\n");

        Subject english = new Subject(1, "English");

        Map<Subject, Integer> yarikGrades = new HashMap<>();
        yarikGrades.put(computerScience, 3);
        yarikGrades.put(english, 3);

        collegeManager.addStudentWithGrades(yarik, yarikGrades);

        System.out.println("System storage at this point:");

        collegeManager.printStudentsInfo();

        System.out.println();

        collegeManager.printSubjectsInfo();

        System.out.println("============================================\n");


        System.out.println("Removing student (Yarik).\n");
        collegeManager.removeStudent(yarik);

        System.out.println("System storage at this point:\n");

        collegeManager.printStudentsInfo();

        System.out.println();

        collegeManager.printSubjectsInfo();

        System.out.println("============================================\n");


        System.out.println("Adding new subject (Biology) with students studying it.\n");

        Subject biology = new Subject(4, "Biology");

        List<Student> biologyListeners = new ArrayList<>(List.of(denis, danil, elisey));

        collegeManager.addSubjectWithStudents(biology, biologyListeners);

        System.out.println("System storage at this point:\n");

        collegeManager.printStudentsInfo();

        System.out.println();

        collegeManager.printSubjectsInfo();

        System.out.println("============================================\n");


        System.out.println("Adding student (Danil) to subject (Computer Science) listeners.\n");
        collegeManager.addStudentToSubjectListeners(danil, computerScience);

        System.out.println("System storage at this point:\n");

        collegeManager.printStudentsInfo();

        System.out.println();

        collegeManager.printSubjectsInfo();

        System.out.println("============================================\n");


        System.out.println("Removing student (Elisey) from subject (biology) listeners.\n");
        collegeManager.removeStudentFromSubjectListeners(elisey, biology);

        System.out.println("System storage at this point:\n");

        collegeManager.printStudentsInfo();

        System.out.println();

        collegeManager.printSubjectsInfo();

        System.out.println("============================================\n");
    }
}
