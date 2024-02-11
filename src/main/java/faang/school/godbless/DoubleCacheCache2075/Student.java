package faang.school.godbless.DoubleCacheCache2075;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Student {
    private int id;
    private String name;
    private static int counter = 0;

    public Student(String name) {
        this.id = ++counter;
        this.name = name;
    }
}
