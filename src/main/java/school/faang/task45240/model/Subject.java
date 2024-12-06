package school.faang.task45240.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Subject {

    private static int counter = 1;
    private final int id;
    private final String name;

    public static final Subject PHYSICS = new Subject("Physics");
    public static final Subject HISTORY = new Subject("History");
    public static final Subject SOCIOLOGY = new Subject("Sociology");
    public static final Subject PHILOSOPHY = new Subject("Philosophy");
    public static final Subject MATH = new Subject("Math");

    public Subject(String name) {
        this.id = counter++;
        this.name = name;
    }
}
