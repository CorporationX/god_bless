package faang.school.godbless.computer.game.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class Player extends Thread {
    private final String playerName;
    private final Boss boss;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.printf("Player %s is fighting with boss\n", playerName);
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boss.leaveBattle(this);
    }

    @Override
    public void run() {
        startBattle(boss);
    }
}
