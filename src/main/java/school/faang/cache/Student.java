package school.faang.cache;

import lombok.Data;

@Data
public class Student {
    private final String name;

    public Student(String name) {
        this.name = name;
    }
}
