package school.faang.stream2.useractivityinsocialnet;

import lombok.Data;

@Data
public class User {
    private static Integer counter = 1;

    private Integer id;
    private final String name;

    public User(String name) {
        this.name = name;
        id = counter++;
    }
}
