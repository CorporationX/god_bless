package faang.school.godbless.alexbulgakoff.countabsense;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Jane", "Biology", "2018");
        Student student2 = new Student("Gorge", "Physical", "2020");
        Student student3 = new Student("Fil", "Computer Science", "2021");
        Student student4 = new Student("Holy", "Design", "2019");
        Student student5 = new Student("Kate", "Machine Learning", "2016");


        List<Student> students = Arrays.asList(
                student1, student2, student3, student4, student5);

        Map<String, List<Student>> map = new HashMap<>();
    }
}
