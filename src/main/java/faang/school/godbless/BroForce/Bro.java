package faang.school.godbless.BroForce;

import lombok.Getter;

@Getter
public class Bro {
    private String name;
    private int lives;
    private boolean isAlive = true;

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public void decreaseLives() {
        lives--;
        isAlive = (lives > 0);
    }
}
