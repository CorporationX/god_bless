package faang.school.godbless.doublecache;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Subject {
    private final int id;
    private final String name;

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
