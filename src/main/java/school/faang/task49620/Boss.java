package school.faang.task49620;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final Logger logger = LoggerFactory.getLogger(Boss.class);

    private static final int MAX_PLAYERS = 3;
    private final List<Player> currentPlayers = new ArrayList<>();

    public void joinBattle(Player player) {
        synchronized (this) {
            while (currentPlayers.size() >= MAX_PLAYERS) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.printf(e.getMessage());
                }
            }
            currentPlayers.add(player);
            logger.info(String.format("Игрок: %s врывается в сражение%n", player.name()));
        }
    }

    public boolean exitBattle(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("player can`t be null");
        }
        if (!currentPlayers.contains(player)) {
            logger.error("Такого игрока нет в сражении.");
            return false;
        }

        synchronized (this) {
            logger.info(String.format("Игрок %s выходит из сражения%n", player.name()));
            currentPlayers.remove(player);
            this.notify();
        }
        return true;
    }
}
