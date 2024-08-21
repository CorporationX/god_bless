package faang.school.godbless.BJS2_24060;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Player {

    private static Random rand = new Random();
    private String name;
    private int lives;

    public int getDurationLife() {
        return rand.nextInt(1, 20);
    }

    public int die() {
        System.out.println(name + " lost one life");
        System.out.println("The number of lives remaining: " + lives);
        return --lives;
    }
}
