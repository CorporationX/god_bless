package school.faang.sprint_3.task_43566;

import lombok.Data;

@Data
public class Player {
    private String name;
    private int lives;
    private int score = 0;
    private boolean isAlive = true;

    public Player(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }
}
