package faang.school.godbless.synchronization.bro_force;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Player {
    private String name;
    private  int lives;
    private int score = 0;
    private boolean isAlive = true;
    public Player(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

}
