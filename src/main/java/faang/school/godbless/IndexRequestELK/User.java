package faang.school.godbless.IndexRequestELK;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class User {

    private static int LAST_ID = 0;

    private final int id;
    private String name;

    public User(String name) {
        this.name = name;
        id = ++LAST_ID;
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s %did", name, id);
    }

}
