package school.faang.double_cache;

import lombok.Data;

@Data
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }
}
