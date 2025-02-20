package school.faang.supercow.BJS2_61566;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Boss {
    private static final Logger LOGGER = LoggerFactory.getLogger(Boss.class);

    private final Object lock = new Object();
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;

        LOGGER.info("Создан босс");
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    LOGGER.info("{} Ждёт свободное место", player.name());

                    lock.wait();
                } catch (InterruptedException e) {
                    LOGGER.error("{}  был прерван во время ожидания.", player.name(), e);
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            LOGGER.info("{} вступает в бой", player.name());

            currentPlayers++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            lock.notify();

            LOGGER.info("{} выходит из боя", player.name());
        }
    }
}
