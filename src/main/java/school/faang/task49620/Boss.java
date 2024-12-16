package school.faang.task49620;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Boss {

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
            log.info("Игрок: {} врывается в сражение", player.name());
        }
    }

    public boolean exitBattle(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("player can`t be null");
        }
        if (!currentPlayers.contains(player)) {
            log.error("Такого игрока нет в сражении.");
            return false;
        }

        synchronized (this) {
            log.info("Игрок {} выходит из сражения", player.name());
            currentPlayers.remove(player);
            this.notify();
        }
        return true;
    }
}
