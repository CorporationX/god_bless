package faang.school.godbless.modul3.broforce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final List<Player> players = new ArrayList<>();

    public void update() {
        Player player = players.get(new Random().nextInt(players.size()));
        synchronized (livesLock) {
            player.setLives(player.getLives() - 1);
            lives++;
            if (player.getLives() == 0) {
                player.setAlive(false);
                gameOver(player);
                synchronized (players) {
                    players.remove(player);
                }
            }
        }
        synchronized (scoreLock) {
            score++;
        }
    }

    public void gameOver(Player player) {
        System.out.println("Game over, " + player.getName() + "; Total score: " + score);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
