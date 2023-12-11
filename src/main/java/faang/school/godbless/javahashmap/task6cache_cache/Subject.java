package faang.school.godbless.javahashmap.task6cache_cache;

import lombok.Data;

@Data
public class Subject {
    private int id;
    private String name;
    private static int count = 0;

    public Subject( String name) {
        this.id = ++count;
        this.name = name;
    }
}
