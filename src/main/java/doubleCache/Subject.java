package doubleCache;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class Subject {
    private static int counter = 0;

    private final int id;
    private final String name;

    public Subject(String name) {
        this.name = name;
        this.id = ++counter;
    }

}
