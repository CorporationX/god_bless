package school.faang.bjs2_90069;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public class Player {
    private final String name;
    private boolean isAlive;
    private int scope = 0;
    private int lives;

    public Player(int lives, boolean isAlive, String name) {
        this.lives = lives;
        this.isAlive = isAlive;
        this.name = name;
    }
}
