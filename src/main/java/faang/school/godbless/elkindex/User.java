package faang.school.godbless.elkindex;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class User {

    private final int id;
    private final String name;
    private static int idFromDB;

    public User(String name) {
        this.name = name;
        this.id = ++idFromDB;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
