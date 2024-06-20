package faang.school.godbless.multithreading_synchronization.task_4;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Bro {
    private final String name;
    private int lives;
    private int score = 0;

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public boolean won() {
        return new Random().nextBoolean();
    }
}
