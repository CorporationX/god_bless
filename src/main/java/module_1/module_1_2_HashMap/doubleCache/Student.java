package module_1.module_1_2_HashMap.doubleCache;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@EqualsAndHashCode
@Getter
@ToString
public class Student {
    private static int counter = 0;

    private final int id;
    private final String name;

    public Student(String name) {
        this.name = name;
        this.id = ++counter;
    }
}
