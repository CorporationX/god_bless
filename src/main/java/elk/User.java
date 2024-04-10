package elk;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@EqualsAndHashCode
@Getter
public class User {
    private int id;
    private String name;
    private static int counterId = 1;

    public User(String name) {
        this.id = counterId;
        this.name = name;
        counterId++;
    }
}
