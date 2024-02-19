package faang.school.godbless.r_edzie.hashmaps.double_cache;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
