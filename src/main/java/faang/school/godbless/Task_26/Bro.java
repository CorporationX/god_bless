package faang.school.godbless.Task_26;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Random;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bro {

    String name;
    int lives;
    int score = 0;

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public boolean getAlive() {
        return new Random().nextBoolean();
    }
}
