package faang.school.godbless.BroForce;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Game {
    private int score;
    private int lives;

    public final Object scoreLock = new Object();
    public final Object livesLock = new Object();

    @Getter
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean update() {
        Player currentPlayer = players.get(new Random().nextInt(players.size()));

        if (currentPlayer.isPlayerSurvived()) {
            synchronized (scoreLock) {
                currentPlayer.setScore(currentPlayer.getScore() + 1);
                score++;
            }
        } else {
            synchronized (livesLock) {
                currentPlayer.setLives(currentPlayer.getLives() - 1);
                lives++;
                System.out.println(currentPlayer);
            }
        }

        if (currentPlayer.getLives() == 0) {
            return gameOver(currentPlayer);
        }
        return false;
    }
    public boolean gameOver(Player player) {
        System.out.println(player.getName() + ": game over mate u noob total score: " + score + " wasted lives: " + lives);
        return true;
    }
}
