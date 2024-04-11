package faang.school.godbless.doublecachecache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class Student {
    private final int id;
    private final String name;
    private static int idFromDB;

    public Student(String name) {
        this.name = name;
        this.id = ++idFromDB;
    }
}
