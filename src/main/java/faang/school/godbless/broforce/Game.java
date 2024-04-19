package faang.school.godbless.broforce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    private int score;
    private int lives;
    private int sumLives;
    private final Object lockForScore = new Object();
    private final Object lockForLives = new Object();
    private final List<Player> players = new ArrayList<>();
    private final Random random = new Random();

    public boolean update() {
        int broIndex = random.nextInt(players.size());
        Player player = players.get(broIndex);
        boolean isAlive = player.getAlive();

        if (!isAlive) {
            synchronized (lockForLives) {
                if((sumLives - lives) >= 2) {
                    player.setLives(player.getLives() - 1);
                    System.out.println("Player " + player.getName() + " have health points: " + player.getLives());
                    lives++;
                    if (player.getLives() == 0) {
                        return gameOver();
                    }
                }
            }
        } else {
            synchronized (lockForScore) {
                player.setScore(player.getScore() + 1);
                score++;
            }
        }
        return false;
    }

    private boolean gameOver() {
        System.out.println("Total score: " + score);
        System.out.println("Total lives: " + lives);
        return true;
    }

    public void addPlayer(Player player) {
        players.add(player);
        sumLives += player.getLives();
    }
}
