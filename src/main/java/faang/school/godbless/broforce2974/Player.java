package faang.school.godbless.broforce2974;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private int lives;
    private int scores;

    public Player(String name) {
        this.name = name;
        this.lives = 3;
    }
}
