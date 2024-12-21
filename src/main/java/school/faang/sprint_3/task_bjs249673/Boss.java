package school.faang.sprint_3.task_bjs249673;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private static final int MILLIS_FIGHTING_TIME = 2000;

    @NonNull
    private final String name;
    private final int maxPlayers;
    private int currentPlayers = 0;

    @SneakyThrows
    public void fightBoss(Player player) {
        joinBattle(player);
        log.info("Player {} fight boss {}", player.name(), this.name);
        Thread.sleep(MILLIS_FIGHTING_TIME);
        leaveBattle(player);
    }

    @SneakyThrows
    private synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            wait();
            log.info("Player {} waiting...", player.name());
        }
        currentPlayers++;
    }

    private synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Player {} left battle", player.name());
        notify();
    }
}
