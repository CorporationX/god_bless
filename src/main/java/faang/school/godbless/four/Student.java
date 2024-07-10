package faang.school.godbless.four;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class Student {
    private static final Random random = new Random();
    @Getter
    private String name;
    private int year;
    @Getter
    private int point;

    public void getAndAddPoint(int reward) {
        if (reward <= 0) {
            throw new IllegalArgumentException("In method getAndaAdd Student class apply int reward <= 0");
        }
        point += reward;
    }

    public static List<Student> getFiveStudent() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            students.add(new Student(
                    "student" + random.nextInt(100),
                    random.nextInt(18, 27),
                    random.nextInt(87)));
        }
        return students;
    }
}
