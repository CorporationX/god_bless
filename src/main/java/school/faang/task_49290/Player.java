package school.faang.task_49290;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Player {
    @EqualsAndHashCode.Include
    private final String name;
    private int lives;
    private int score;
    private boolean isAlive;

    public Player(String name, int lives) {
        this.name = name;
        this.lives = lives;
        score = 0;
        isAlive = true;
    }

    public void removeLive() {
        if (lives > 0) {
            lives--;
        }
    }

    public void addScore() {
        score++;
    }
}
