package school.faang.sprint3.supercow;

import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Player {
    private static final Integer NAME_LENGTH_MAX = 6;
    private static final Integer BATTLE_TIME_SECONDS_MAX = 3;

    private final Random random = new Random();
    @Getter
    private final String name;

    public Player(int playerNumber) {
        this.name = String.valueOf(playerNumber);
    }

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            int randomTime = random.nextInt(BATTLE_TIME_SECONDS_MAX) + 1;
            Thread.sleep(TimeUnit.SECONDS.toMillis(randomTime));
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Ошибка sleep() %s.\n", e.getMessage());
        }
    }
}
