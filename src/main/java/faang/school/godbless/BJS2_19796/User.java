package faang.school.godbless.BJS2_19796;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
public class User {
    private static int nextId = 0;
    private final int id;
    private String name;

    public User(String name) {
        this.id = nextId++;
        this.name = name;
        System.out.println("Created user " + this.name + " with id " + this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User u) {
            return this.id == u.id && this.name.equals(u.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
