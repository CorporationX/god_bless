package school.faang.doublecash;

import lombok.Getter;

@Getter
public class Student {
    private int id;
    private String name;

    public Student(String name) {
        this.name = name;
    }
}
