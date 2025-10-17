package school.faang.bjs2_90138;

import java.util.Random;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Bro {

    private String name;
    private int lives = 5;
    private int score = 0;

    public boolean isAlive() {
        Random random = new Random();
        return random.nextBoolean();
    }
}