package school.faang.naughtwoBJS261662;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Boss {
    private final String name;
    private final int maxPlayers;
    @Setter
    private int currentPlayers;

    private final Object lock = new Object();
    private static final int MINIMUM_PLAYERS = 1;

    public Boss(String name, int maxPlayers) {
        checkName(name);
        checkMaxPlayers(maxPlayers);
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("There are no free slots to join the battle.");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Thread was interrupted while waiting to join the battle", e);
                }
            }
            currentPlayers++;
            log.info("{} joined the boss fight", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} completed the boss fight", player.getName());
            lock.notify();
        }
    }

    private void checkMaxPlayers(int maxPlayers) {
        if (maxPlayers < MINIMUM_PLAYERS) {
            throw new IllegalArgumentException(String.format("Max players cannot be less than %d", MINIMUM_PLAYERS));
        }
    }

    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be 'null' or empty");
        }
    }
}
