package school.faang.comments;

import lombok.Data;

@Data
public class User {
    private static int currentId = 0;

    private int id;
    private String name;

    User(String name) {
        this.id = ++currentId;
        this.name = name;
    }
}
