package school.faang.supercow;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Set<Player> playersInBattle = new HashSet<>();

    public synchronized void joinBattle(@NonNull Player player) {
        if (currentPlayers == maxPlayers) {
            try {
                log.info("Player {} is waiting for an available slot...", player.name());
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread {} was interrupted while waiting to join the battle.", this.currentPlayers, e);
                return;
            }
        }
        currentPlayers++;
        playersInBattle.add(player);
        log.info("Player {} joined the battle.", player.name());
    }

    public synchronized void leaveBattle(@NonNull Player player) {
        if (!playersInBattle.contains(player)) {
            throw new IllegalArgumentException("This player is not in the battle!");
        }
        currentPlayers--;
        playersInBattle.remove(player);
        this.notify();
        log.info("PLayer {} left the battle.", player.name());
    }

    public void status() {
        log.info("Players: {} / {}", currentPlayers, maxPlayers);
    }
}
