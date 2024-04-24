package faang.school.godbless.leave_a_comment;

import lombok.Data;

@Data
public class User {
    private static int startId = 0;
    private int id;
    private String name;

    public User(String name) {
        this.id = startId++;
        this.name = name;
    }
}