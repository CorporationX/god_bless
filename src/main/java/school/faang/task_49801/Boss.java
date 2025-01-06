package school.faang.task_49801;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("{} is waiting", player.name());
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("{} was interrupted", player.name());
                }

            }
            currentPlayers++;
            log.info("{} Added to battle. Now {} players", player.name(), currentPlayers);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            leaveButtle(player);
        }
    }

    public void leaveButtle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} has finished battle. Now {} players", player.name(), currentPlayers);
            lock.notify();
        }
    }
}
