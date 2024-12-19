package school.faang.task_49640;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private static final int ONE_SECOND = 1000;
    private final int maxPlayers;
    private final Object lock = new Object();
    private int currentPlayers;

    @SneakyThrows
    public void joinBattle(Player player) {
        synchronized (lock) {
            if (maxPlayers - currentPlayers > 0) {
                currentPlayers++;
                log.info("Player {} joined in battle and start battle", player);
                Thread.sleep(ONE_SECOND);
                log.info("Player {} ended battle", player);
                currentPlayers--;
                lock.notify();
            } else {
                lock.wait();
            }
        }
    }
}
