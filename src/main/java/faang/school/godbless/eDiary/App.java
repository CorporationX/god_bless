package faang.school.godbless.eDiary;

import java.util.*;
public class App {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student();
        student1.setFirstName("Justin");
        student1.setLastName("Bieber");
        Map<String, List<Integer>> courses1 = new HashMap<>();
        courses1.put("Mathematics", Arrays.asList(5, 4, 4));
        courses1.put("Literature", Arrays.asList(4, 5, 3));
        courses1.put("Chemistry", Arrays.asList(4, 3, 3));
        student1.setCourses(courses1);
        students.add(student1);

        Student student2 = new Student();
        student2.setFirstName("Bruno");
        student2.setLastName("Mars");
        Map<String, List<Integer>> courses2 = new HashMap<>();
        courses2.put("Mathematics", Arrays.asList(3, 4, 5));
        courses2.put("Literature", Arrays.asList(3, 3, 3));
        courses2.put("Chemistry", Arrays.asList(4, 1, 4));
        student2.setCourses(courses2);
        students.add(student2);

        ElectronicDiary diary = new ElectronicDiary(students);
        String table = diary.generateTable();
        System.out.println(table);
    }

}
