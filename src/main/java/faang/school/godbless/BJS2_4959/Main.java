package faang.school.godbless.BJS2_4959;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        Student john = new Student("John", "engineer", 1);
        Student marie = new Student("John", "economy", 2);
        Student mike = new Student("mike", "transport", 3);

        students.add(john);
        students.add(marie);
        students.add(mike);

        System.out.println(students);
    }
}
