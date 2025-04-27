package school.faang.sprint3multythreading.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers >= maxPlayers) {
                try {
                    log.info("Подожди отважный боец {} в очереди. Босс занят битвой.", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("{} не дождался битвы и уснул.", player.getName());
                }
            }
            currentPlayers++;
            log.info("{} присоединился к битве с Боссом.", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} пошел отдохнуть после битвы с Боссом.", player.getName());
            lock.notify();
        }
    }
}