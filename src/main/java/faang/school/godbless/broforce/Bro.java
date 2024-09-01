package faang.school.godbless.broforce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bro {
    private String name;
    private int lives;
    private int score;
    private boolean isAlive = true;

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }
}