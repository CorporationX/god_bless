package faang.school.godbless.BJS2_19821;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class User {
    private static int userIndex = 0;
    private int id;
    @Getter
    private String name;

    public User(String name) {
        this.id = ++userIndex;
        this.name = name;
    }
}
