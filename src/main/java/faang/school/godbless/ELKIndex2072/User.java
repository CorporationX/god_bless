package faang.school.godbless.ELKIndex2072;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private int id;
    private String name;
    private static int counter = 0;

    public User(String name) {
        this.id = ++counter;
        this.name = name;
    }

}
