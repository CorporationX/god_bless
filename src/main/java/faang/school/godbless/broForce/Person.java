package faang.school.godbless.broForce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private final String name;
    private int lives;
    private int score;

    public Person(String name) {
        this.name = name;
        this.lives = 3;
        this.score = 0;
    }
}
