package faang.school.godbless.queryindex;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class User {
    private static int userIdCounter = 0;

    private int id;
    private String name;

    public User(String name) {
        id = ++userIdCounter;
        this.name = name;
    }
}
