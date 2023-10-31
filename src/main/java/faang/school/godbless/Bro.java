package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Bro {
    private String name;
    private int score;
    private int lives;
    private boolean isAlive;

    public boolean getAlive(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
