package school.faang.task45240.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class Student {
    private static int counter = 1;
    private final int id;
    private final String name;

    public Student(String name) {
        this.id = counter++;
        this.name = name;
    }

}
