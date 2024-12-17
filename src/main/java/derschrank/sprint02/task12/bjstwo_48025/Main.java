package derschrank.sprint02.task12.bjstwo_48025;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        StudentLoader studentLoader = new StudentLoader();

        System.out.println("1) All students was loaded: ");
        List<Student> students = studentLoader.loadStudents();
        System.out.println(students);

        StudentManager manager = new StudentManager();
        System.out.println("\n2) Average grades by School:");
        System.out.println(manager.getAverageGradeBySchool(students));

        System.out.println("\n3) Average grades by students:");
        System.out.println(manager.getAverageGradeByStudent(students, "Oleg", "Sidorov"));

        System.out.println("\n4) Most hard subject:");
        System.out.println(manager.getMostHardSubject(students));

        System.out.println("\n5) Print table of Students:");
        manager.printTableOfStudentsWithGrade(students);

    }
}
