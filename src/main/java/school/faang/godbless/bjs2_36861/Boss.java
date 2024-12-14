package school.faang.godbless.bjs2_36861;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private final Set<Player> currentPlayers = new HashSet<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers.size() >= maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.warn("Interrupted when waiting for free slot for the boss fight");
                Thread.currentThread().interrupt();
            }
        }
        currentPlayers.add(player);
        log.info("Player {} has joined the boss fight", player.getName());
        logCurrentPlayers();
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers.contains(player)) {
            currentPlayers.remove(player);
            notifyAll();
            log.info("Player {} has left the boss fight", player.getName());
            logCurrentPlayers();
        } else {
            log.warn("Tried to remove player from the battle they did not join");
        }
    }

    private void logCurrentPlayers() {
        log.info("Currently there are {} players in the fight", currentPlayers.size());
    }
}
