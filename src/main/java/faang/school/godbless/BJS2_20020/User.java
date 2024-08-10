package faang.school.godbless.BJS2_20020;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
