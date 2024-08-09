package faang.school.godbless.elk.models;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class User {

    private static int counter = 0;

    private final int id;
    private final String name;

    public User(String name) {
        this.id = counter;
        this.name = name;
        counter++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
