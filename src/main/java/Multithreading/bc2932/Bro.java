package Multithreading.bc2932;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Bro {
    private String name;
    private int lives;
    private int score = 0;
    private boolean alive;

    public Bro(String name, int lives, boolean alive) {
        this.name = name;
        this.lives = lives;
        this.alive = alive;
    }

    public boolean getAlive() {
        return new Random().nextBoolean();
    }
}
