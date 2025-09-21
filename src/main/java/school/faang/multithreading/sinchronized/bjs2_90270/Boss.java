package school.faang.multithreading.sinchronized.bjs2_90270;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Boss {
    private static final int MAX_COUNT_PLAYERS_BATTLE = 4;

    private final String bossName;
    private final int maxPlayers = MAX_COUNT_PLAYERS_BATTLE;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(String bossName) {
        this.bossName = bossName;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("'{}' ждет свободного слота", player.name());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("'{}' был прерван во время ожидания", player.name());
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                log.info("Мест на рейд пока нет!");
            }
            currentPlayers++;
            log.info("Игрок '{}' присоединяется к рейду на '{}'", player.name(), bossName);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            lock.notify();
            log.info("Игрок '{}' покидает рейд", player.name());
        }
    }
}
