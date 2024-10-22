package tasks.bjs2_36987;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@AllArgsConstructor
@ToString
public class Player {
    private static final Random RANDOM = new Random();
    private static final int MIN_DELAY = 2000;
    private static final int MAX_DELAY = 10000;
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println(name + " вступил в сражение с боссом");

        try {
            Thread.sleep(RANDOM.nextInt(MIN_DELAY, MAX_DELAY));
        } catch (InterruptedException e) {
            throw new IllegalStateException("В процессе выполнения произошла ошибка : " + e.getMessage());
        }

        boss.leaveBattle(this);
        System.out.println(name + " погиб в сражение с боссом");
    }
}
