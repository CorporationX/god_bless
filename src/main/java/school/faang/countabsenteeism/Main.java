package school.faang.countabsenteeism;

import java.util.ArrayList;
import java.util.List;

import static school.faang.countabsenteeism.StudentService.add;
import static school.faang.countabsenteeism.StudentService.getStudentsByStudentProfile;
import static school.faang.countabsenteeism.StudentService.printAll;
import static school.faang.countabsenteeism.StudentService.printForTest;
import static school.faang.countabsenteeism.StudentService.remove;

public class Main {
    public static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        add(new Student("Dmitry", new StudentProfile("Humanities", 1)));
        add(new Student("Yaroslav", new StudentProfile("Mathematics", 3)));
        add(new Student("Sergei", new StudentProfile("Humanities", 1)));
        add(new Student("Alexey", new StudentProfile("Humanities", 3)));
        add(new Student("Alena", new StudentProfile("Chemistry", 2)));
        add(new Student("Anastasia", new StudentProfile("Chemistry", 2)));
        add(new Student("Anatoly", new StudentProfile("Chemistry", 2)));
        add(new Student("Ruslan", new StudentProfile("Chemistry", 2)));

        remove("Yaroslav", "Mathematics", 3);
        remove("Dmitry", "Humanities", 1);


        List<Student> testGetStudents = getStudentsByStudentProfile("Chemistry", 2);
        printForTest(testGetStudents);

        printAll(STUDENTS);
    }
}
