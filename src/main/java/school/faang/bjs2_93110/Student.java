package school.faang.bjs2_93110;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Student {
    private String name;
    private int year;
    @Setter private int points = 0;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }
}
