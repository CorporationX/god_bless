package school.faang.supercow;

import java.util.logging.Logger;

public class Boss {
    private static final Logger LOGGER = Logger.getLogger(Boss.class.getName());
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        try {
            while (currentPlayers >= maxPlayers) {
                LOGGER.info(player.getName() + " is waiting for a slot");
                this.wait();
            }
            LOGGER.info(player.getName() + " joined the battle");
            currentPlayers++;
        } catch (InterruptedException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        // LOGGER.info(player.getName() + " left the battle");
        this.notifyAll();
    }

}
