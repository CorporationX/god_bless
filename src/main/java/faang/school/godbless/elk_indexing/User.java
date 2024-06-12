package faang.school.godbless.elk_indexing;

import java.util.Objects;

public class User {
    private final String name;
    private final int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " " + id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        Objects.requireNonNull(obj);
        if (!(this == obj) && obj.getClass() != this.getClass()) return false;
        User other = (User) obj;
        return id == other.id && Objects.equals(name, other.name);
    }
}
