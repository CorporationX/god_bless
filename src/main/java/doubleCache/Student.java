package doubleCache;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@EqualsAndHashCode
@Getter
@ToString
public class Student {
    private static long counter = 0L;

    private final long id;
    private final String name;

    public Student(String name) {
        this.name = name;
        this.id = ++counter;
    }
}
