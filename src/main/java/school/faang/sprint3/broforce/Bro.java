package school.faang.sprint3.broforce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Bro {
    private String name;
    private int lives;
    private int score;
    private boolean alive;

    public boolean getAlive() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
