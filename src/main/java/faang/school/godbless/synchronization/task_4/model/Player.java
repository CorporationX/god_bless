package faang.school.godbless.synchronization.task_4.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private final String name;
    @Setter
    private boolean alive;
    @Setter
    private int lives;
    @Setter
    private int score;

    public Player(String name, int lives, boolean alive) {
        this.name = name;
        this.lives = lives;
        this.alive = alive;
    }

    public boolean isAlive() {
        return lives > 0;
    }
}