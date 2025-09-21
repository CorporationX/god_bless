package school.faang.bjs2_90291;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers == maxPlayers) {
                try {
                    log.info("{} ждет пока освободится место.", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток прерван {}", e);
                }
            }

            currentPlayers++;
            log.info("{} присоединился к игре. Количество игроков: {}", player.getName(), currentPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} вышел из игры. Количество игроков: {}", player.getName(), currentPlayers);
            lock.notifyAll();
        }
    }
}
