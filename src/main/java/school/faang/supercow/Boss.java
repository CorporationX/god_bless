package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        if (maxPlayers <= 0) {
            throw new IllegalArgumentException("maxPlayers must be positive");
        }
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (currentPlayers == maxPlayers) {
                log.info("Максимальное колличество в файтинге, жди, {}", player.name());
                lock.wait();
            }
            log.info("{}, настало твое время. Дерись или беги", player.name());
            currentPlayers++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            log.info("С победой/поражением, {}. Верное выбери сам", player.name());
            currentPlayers--;
            lock.notify();
        }
    }


}
