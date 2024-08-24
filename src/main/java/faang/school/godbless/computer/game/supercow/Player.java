package faang.school.godbless.computer.game.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
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
            log.error(String.format("Interrupted while player %s was fighting with boss", playerName));
            Thread.currentThread().interrupt();
        }
        boss.leaveBattle(this);
    }

    @Override
    public void run() {
        startBattle(boss);
    }
}
