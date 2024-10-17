package count.absenteeism;

import java.util.ArrayList;

import static count.absenteeism.Student.addStudent;
import static count.absenteeism.Student.groupStudents;
import static count.absenteeism.Student.printAll;
import static count.absenteeism.Student.removeStudent;
import static count.absenteeism.Student.searchStudent;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            students.add(new Student("Ivan", "IT", 3));
            students.add(new Student("Karl", "FIN", 2));
            students.add(new Student("Pavel", "SPORT", 1));

            addStudent(students, new Student("Kira", "KIT", 5));
            addStudent(students, new Student("Poli", "IT", 4));
            removeStudent(students, "Karl", "FIN", 2);
            groupStudents(students);
            searchStudent(students, "SPORT", 1);
            printAll(groupStudents(students));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
