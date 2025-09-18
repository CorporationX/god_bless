package school.faang.bjs2_90253;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;


@AllArgsConstructor
@Getter
@Slf4j
@ToString
public class Player {
    private static int MIN_TIME = 5000;
    private static int MAX_TIME = 15000;
    private final String name;

    public void doBattle(Boss boss) {
        Random random = new Random();
        boss.joinBattle(this);
        int timeBattle = random.nextInt(MIN_TIME, MAX_TIME);
        try {
            Thread.sleep(timeBattle);
        } catch (InterruptedException e) {
            log.error("the player {} interrupted the boss battle", this, e);
            Thread.currentThread().interrupt();
        }
        boss.leaveBattle(this);

    }
}
