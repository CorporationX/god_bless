package HarryPotter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;
    private int year = 1990;
    private int points = 0;

    public Student(String name) {
        this.name = name;
    }
}
