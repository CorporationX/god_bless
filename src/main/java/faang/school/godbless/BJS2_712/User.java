package faang.school.godbless.BJS2_712;

import lombok.Data;

@Data
public class User {
    private static int count;
    private int id;
    private String name;

    public User(String name) {
        this.id = ++count;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User id = " + id + ", name = " + name;
    }
}