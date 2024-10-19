package school.faang.supercow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Player {
    @Getter
    private final String name;
    private Boss currentBoss;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        if (boss == null) {
            throw new IllegalArgumentException("Boss не может быть null");
        }
        if (currentBoss != null) {
            throw new IllegalStateException("На данный момент игрок уже находится в битве");
        }
        currentBoss = boss;
        boss.joinBattle(this);
        System.out.println("Игрок " + name + " сражается с боссом");
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
        boss.leaveBattle(this);
    }
}
