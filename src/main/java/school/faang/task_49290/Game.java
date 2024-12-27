package school.faang.task_49290;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private final Set<Player> players = new HashSet<>();
    private int score;
    private int lives;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Set<Player> getPlayers() {
        return new HashSet<>(players);
    }

    public void update(Player player) {
        if (player.isAlive()) {
            synchronized (scoreLock) {
                player.addScore();
                score++;
                System.out.println("Player '" + player.getName() + "' earned a score, total: " + player.getScore());
                System.out.println("Total game score: " + score);
            }
        } else if (player.getLives() > 1) {
            synchronized (livesLock) {
                player.removeLive();
                lives++;
                System.out.println("Player '" + player.getName() + "' lost a life, total: " + player.getLives());
                System.out.println("Total game lives: " + lives);
                player.setAlive(true);
            }
        } else {
            gameOver(player);
        }
    }

    private void gameOver(Player player) {
        synchronized (livesLock) {
            player.removeLive();
            lives++;
            players.remove(player);
            System.out.println("Game over for '" + player.getName() + "'");
            System.out.println("Total game lives: " + lives);
        }
    }
}
