package faang.school.godbless.elkindex;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class User {

    private final int id;
    private final String name;
    private static int idFromDB;

    public User(String name) {
        this.name = name;
        this.id = ++idFromDB;
    }
}
