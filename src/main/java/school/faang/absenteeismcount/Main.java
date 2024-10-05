package school.faang.absenteeismcount;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Liza", "psiho", "1"),
                new Student("Evgen", "it", "2"),
                new Student("Sonya", "psiho", "1"),
                new Student("Grisha", "develop", "3"),
                new Student("Liza", "develop", "3")
        );

        var university = new University(students);
        university.showAllStudents();
        university.deleteStudent("Liza", "psiho", "1");
        university.showAllStudents();
        university.addNewStudent("Viktor", "develop", "1");
        System.out.println(university.returnStudentsListByFacultyAndYear("develop", "3"));
    }
}
