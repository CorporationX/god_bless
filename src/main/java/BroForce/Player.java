package BroForce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private int lives = 3;
    private boolean isAlive = true;

    public Player(String name) {
        this.name = name;
    }

    public void updateLives() {
        lives--;
    }
}
