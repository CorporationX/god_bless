package school.faang.broforce;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Bro {

    @Getter
    private final String name;
    private int lives;

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public void removeLife() {
        lives--;
    }

    public boolean isAlive() {
        return lives > 0;
    }
}
