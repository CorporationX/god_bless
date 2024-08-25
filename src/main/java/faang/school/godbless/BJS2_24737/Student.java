package faang.school.godbless.BJS2_24737;

import lombok.Data;

@Data
public class Student {
    private String name;
    private int year;
    private int points = 0;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void addPoints(int num) {
        points += num;
    }
}
