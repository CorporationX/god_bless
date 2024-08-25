package faang.school.godbless.supercow;

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
        while (currentPlayers == maxPlayers) {
            try {
                log.info("There are no available slots...");
                wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
        currentPlayers++;
        log.info("Player {} joined the fight", player.name());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Player {} left the fight", player.name());
        notifyAll();
    }
}