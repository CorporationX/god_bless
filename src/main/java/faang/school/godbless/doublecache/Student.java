package faang.school.godbless.doublecache;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Student {
    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
