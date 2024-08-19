package faang.school.godbless.Maps.BJS2_20011;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.util.concurrent.ThreadLocalRandom;

@EqualsAndHashCode
@Getter
public class User {
    private final int id;
    private String name;

    public User(String name) {
        this.name = name;
        id = ThreadLocalRandom.current().nextInt(1, 1000);
    }
}
