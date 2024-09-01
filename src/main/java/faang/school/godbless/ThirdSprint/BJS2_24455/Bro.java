package faang.school.godbless.ThirdSprint.BJS2_24455;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
public class Bro {
    private String name;
    private int lives;
    private boolean isAlive;

    public boolean getIsAlive(){
        Random random = new Random();
        return random.nextBoolean();
    }
    public int getCurrentStat(){
        return ThreadLocalRandom.current().nextInt(0, 3);
    }
}
