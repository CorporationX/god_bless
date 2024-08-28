package faang.school.godbless.bjs2_24361;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = new ArrayList<>();
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers.size() == maxPlayers) {
            try {
                log.info("Player {} is waiting for when anybody leave the battle", player.getName());
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        }
        currentPlayers.add(player);
        log.info("Player {} started the battle", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers.remove(player);
        log.info("Player {} left the battle", player.getName());
        notify();
    }
}
