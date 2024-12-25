package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            log.info("{} ожидает освобождение слота", player.getName());
            try {
                wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        currentPlayers++;
        log.info("{} начал сражение", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("{} завершил сражение", player.getName());
        notifyAll();
    }
}
