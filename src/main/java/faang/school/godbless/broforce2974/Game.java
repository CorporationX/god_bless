package faang.school.godbless.broforce2974;

import java.util.Random;

public class Game {
    private int score;
    private int lives;
    private final Object SCORE_LOCK = new Object();
    private final Object LIVES_LOCK = new Object();
    private static final Random RANDOM = new Random();

    public void startGame(Player player) {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            update(player);
        }
    }

    private void update(Player player) {
        synchronized (this.SCORE_LOCK) {
            this.score++;
            player.setScores(player.getScores() + 1);
            System.out.printf("""
                            Total scores of all players: %d
                            %s scores: %d
                            """,
                    this.score, player.getName(), player.getScores());
        }
        synchronized (this.LIVES_LOCK) {
            if (RANDOM.nextInt(100) <= 20) {
                this.lives++;
                player.setLives(player.getLives() - 1);
                System.out.printf("Ouch! %s got hit. Lives left: %d%n",
                        player.getName(), player.getLives());
            }
            if (player.getLives() == 0) {
                gameOver(player);
            }
        }
    }

    private void gameOver(Player player) {
        System.out.printf("%s is dead:(%n", player.getName());
        Thread.currentThread().interrupt();
    }
}
