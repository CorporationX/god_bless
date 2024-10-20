package school.faang.broforce;

import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class Game {
    private int score;
    private int lives;
    private List<Player> players;
    private Object livesLock = new Object();
    private Object scoresLock = new Object();
    private boolean isGameStart;

    public Game(List<Player> players) {
        this.players = players;
        for (Player player : players) {
            this.lives += player.getLive();
        }
    }

    public void startGame() {
        isGameStart = true;
        System.out.println("The game is start!");
    }

    public synchronized void updateGameProcess() {
        while (isGameStart == true) {
            gameProcess();
        }
        if (isGameStart == false) {
            System.out.println("The game is over!");
            System.out.println("Total points per game: " + getScore());
            players.stream()
                    .sorted((p1, p2) -> p2.getScore() - p1.getScore())
                    .forEach(player -> System.out.println("The player " + player.getName() +
                            " earned " + player.getScore() +
                            " points for the game session!"));
        }
    }

    public void gameProcess() {
        reductionOfLives();
        increasePoints();
    }

    private void reductionOfLives() {
        synchronized (scoresLock) {
            Random random = new Random();
            for (Player player : players) {
                boolean isGetScore = random.nextBoolean();
                if (isGetScore && player.getLive() > 0) {
                    this.score += 100;
                    player.setScore(player.getScore() + 100);
                    System.out.println("The player " + player.getName() + " earned one point");
                }
            }
        }
    }

    private void increasePoints() {
        synchronized (livesLock) {
            if (lives == 0) {
                gameOver();
            }
            Random random = new Random();
            for (Player player : players) {
                boolean isLifeWasted = random.nextBoolean();
                if (isLifeWasted && player.getLive() > 0) {
                    this.lives--;
                    player.setLive(player.getLive() - 1);
                    System.out.println("The player " + player.getName() + " lost life");
                    System.out.println("The player " + player.getName() + " now has " + player.getLive() + " lives");
                }
            }
        }
    }

    private void gameOver() {
        isGameStart = false;
    }
}
