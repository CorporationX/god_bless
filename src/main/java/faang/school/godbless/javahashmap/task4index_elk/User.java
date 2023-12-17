package faang.school.godbless.javahashmap.task4index_elk;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private static int count;

    public User(String name) {
        this.id = ++count;
        this.name = name;
    }
}
