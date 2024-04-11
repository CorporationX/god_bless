package faang.school.godbless.doublecachecache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class Subject {
    private final int id;
    private final String name;
    private static int idFromDB;

    public Subject(String name) {
        this.name = name;
        this.id = ++idFromDB;
    }
}
