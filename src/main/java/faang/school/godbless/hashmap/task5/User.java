package faang.school.godbless.hashmap.task5;

import lombok.AllArgsConstructor;
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
