package faang.school.godbless.synchronization.supercow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private String name;

    public Boss(int maxPlayers, String name) {
        this.maxPlayers = maxPlayers;
        this.name = name;
        currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        if (player == null) {
            return;
        }

        if (currentPlayers + 1 > maxPlayers) {
            try {
                log.info("Player " + player.getName() + " can't join the boss (" + name +"). Boss fight has reached max players count.");
                this.wait();
            } catch (InterruptedException e) {
                log.error("Waiting for free slot to fight boss was interrupted.");
                return;
            }
        }

        currentPlayers++;
        log.info("Player " + player.getName() + " joined the boss (" + name + ") fight ");
    }

    public synchronized void leaveBattle(Player player) {
        if (player == null) {
            return;
        }

        if (currentPlayers - 1 < 0) {
            log.warn("Player " + player.getName() + " tried to leave empty boss (" + name + ") fight.");
            return;
        }

        currentPlayers--;

        log.info("Player " + player.getName() + " left the boss (" + name + ") fight.");

        this.notify();
    }
}
