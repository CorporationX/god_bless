package school.faang.BJS2_61694;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@Getter
@Setter
public class Bro {
    private final String name;
    private int lives;
    private int score;

    public Bro(String name) {
        this.name = name;
        this.lives = ConstAndMessages.DEFAULT_LIVES;
    }

    public boolean isWinnenAttack() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
