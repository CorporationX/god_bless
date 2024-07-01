package faang.school.godbless.synchronization.sypercow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Boss {
    private int maxPlayers;
    private List<Player> currentPlayers = new ArrayList<>();
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void addPlayerToBattle(Player player) {
        if (currentPlayers.size() >= maxPlayers) {
            try {
                log.info(String.format("Slots is full! %s please wait....", player.getName()));
                this.wait();
            } catch (InterruptedException e) {
                log.error("Thread is interrupted when players waiting free slots!");
                throw new RuntimeException("Thread is interrupted when players waiting free slots!", e);
            }
        }
        log.info(String.format("%s joined the battle", player.getName()));
        currentPlayers.add(player);
    }

    public synchronized void removePlayerFromBattle(Player player) {
        if (currentPlayers.contains(player)) {
            log.info(String.format("%s left the battle", player.getName()));
            currentPlayers.remove(player);
            this.notifyAll();
        }
    }
}


