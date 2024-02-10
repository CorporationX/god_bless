package faang.school.godbless.elk;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
