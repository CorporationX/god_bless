package faang.school.godbless.bro_forse;

import java.util.List;

public class Game {
    private int score;
    private int lives;
    private final List<Player> players;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update() {
        synchronized (scoreLock) {
            for (Player player : players) {
                player.setScore(player.getScore() + 1);
                score++;
                System.out.println(player.getName() + " get a point. Total points is: " + player.getScore());
            }
        }

        synchronized (livesLock) {
            for (Player player : players) {
                if (player.isAlive()) {
                    player.setLives(player.getLives() - 1);
                    lives++;
                    System.out.println(player.getName() + " lost live. Lives left: " + player.getLives());
                } else {
                    gameOver();
                }
            }
        }
    }


    private void gameOver() {
        System.out.println("Game is over");
        System.out.println("Total score: " + score);
        System.out.println("Total lost lives " + lives);
        System.exit(0);
    }

    public Game(List<Player> players) {
        this.players = players;
    }
}

