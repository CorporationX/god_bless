package school.faang.bjs2_32590;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>() {{
            add(new Student("Alex", "Engineering", 2));
            add(new Student("Maria", "Arts", 1));
            add(new Student("John", "Science", 3));
            add(new Student("Emily", "Business", 4));
            add(new Student("Michael", "Law", 2));
        }};
    }
}
