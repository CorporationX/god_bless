package faang.school.godbless.Maps.BJS2_20011;

import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@EqualsAndHashCode
public class User {
    private final int id;
    private String name;

    public User(String name) {
        this.name = name;
        id= ThreadLocalRandom.current().nextInt(1, 1000);
    }
}
