package school.faang.task45240.model;

import lombok.Data;

@Data
public class Subject {

    private static int counter = 1;
    private final int id;
    private final String name;

    public final static Subject PHYSICS = new Subject("Physics");
    public final static Subject HISTORY = new Subject("History");
    public final static Subject SOCIOLOGY = new Subject("Sociology");
    public final static Subject PHILOSOPHY = new Subject("Philosophy");
    public final static Subject MATH = new Subject("Math");

    public Subject(String name)
    {
        this.id = counter++;
        this.name = name;
    }
}
