package faang.school.godbless.DoubleCacheCache;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Student {
    private static int LAST_ID = 0;

    private int id;
    private String name;

    public Student(String name) {
        this.name = name;
        this.id = ++LAST_ID;
    }
}
