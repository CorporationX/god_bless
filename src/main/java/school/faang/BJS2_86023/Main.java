package school.faang.BJS2_86023;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();
        Map<Subject, Integer> map = new HashMap<>();
        Subject sub = new Subject("math");
        map.put(sub, 2);
        map.put(new Subject("English"), 5);
        database.addStudentSubjects(new Student("Alex"), map);
        map.put(new Subject("math"), 5);
        map.put(new Subject("informatics"), 4);
        database.addStudentSubjects(new Student("Ignat"), map);
        database.printStudentSubjects();
    }
}
