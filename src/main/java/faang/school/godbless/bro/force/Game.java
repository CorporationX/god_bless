package faang.school.godbless.bro.force;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Game {
    private int score;
    private int lives;
    private List<Player> players = new ArrayList<>();

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean update() {
        Random random = new Random();
        int playerIndex = random.nextInt(players.size());
        Player player = players.get(playerIndex);
        boolean isAlive = player.getAlive();

        if (!isAlive) {
            synchronized (livesLock) {
                player.setLives(player.getLives() - 1);
                lives++;
                System.out.println(player.getName() + " lives: " + player.getLives());
                if (player.getLives() == 0) {
                    return gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                player.setScore(player.getScore() + 1);
                score++;
            }
        }
        return false;
    }

    public boolean gameOver() {
        System.out.println("Game over with score " + score);
        System.out.println("Lost lives " + lives);
        return true;
    }
}
