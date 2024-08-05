package faang.school.godbless.BJS2_19421;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Rohn", "Слизерин", 2));
        students.add(new Student("Max", "Слизерин", 2));
        students.add(new Student("Elon", "Гриффиндор", 1));
        students.add(new Student("Alice", "Гриффиндор", 1));

        Student.addStudent(students, new Student("Jacob", "Слизерин", 3));

        Student.searchStudents(students, "Слизерин", 2);

        Map<String, List<Student>> result = Student.groupStudents(students);
        Student.printStudentsGrouped(result);
    }
}
