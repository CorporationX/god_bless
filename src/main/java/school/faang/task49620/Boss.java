package school.faang.task49620;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private static final int MAX_PLAYERS = 3;
    private final List<Player> currentPlayers = new ArrayList<>();

    public void joinBattle(Player player) {
        synchronized (this) {
            if (currentPlayers.size() >= MAX_PLAYERS) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.printf(e.getMessage());
                }
            }
            currentPlayers.add(player);
            System.out.printf("Игрок: %s врывается в сражение%n", player.name());
        }
    }

    public boolean exitBattle(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("player can`t be null");
        }
        if (!currentPlayers.contains(player)) {
            System.out.println("Такого игрока нет в сражении.");
            return false;
        }

        synchronized (this) {
            System.out.printf("Игрок %s выходит из сражения%n", player.name());
            currentPlayers.remove(player);
            this.notify();
        }
        return true;
    }
}
