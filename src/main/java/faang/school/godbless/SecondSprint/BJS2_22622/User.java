package faang.school.godbless.SecondSprint.BJS2_22622;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public class User {
    private String name;
    private int id;

    public User(String name) {
        this.name = name;
        id = ThreadLocalRandom.current().nextInt(1, 1000);
    }
}
