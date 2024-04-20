package broForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private static final int MAX_PLAYERS = 4;
    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private final List<Player> players = new ArrayList<>();
    private final Random random = new Random();

    public void update() {
        while (true) {
            synchronized (lockScore) {
                players.forEach(player -> {
                    if (player.getLives() <= 0) {
                        try {
                            lockScore.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                score++;
                System.out.println(score);
            }
            synchronized (lockLives) {
                Player player = players.get(random.nextInt(1, MAX_PLAYERS));
                player.setLives(player.getLives() - 1);
                gameOver(player);
                lives++;

            }
        }
    }

    private void gameOver(Player player) {
        if (lives > 4) {
            checkPlayer(player);
            if (player.getLives() <= 0) {
                System.out.println("Game over");
                System.out.printf("Player %s lost all lives\n", player.getName());
                System.out.println("Total score: " + score);
                System.out.println("Total lost lives: " + lives);
                System.exit(0);
            }
        }
    }

    public void addPlayer(Player player) {
        checkPlayer(player);
        players.add(player);
    }

    private void checkPlayer(Player player) {
        if (player == null) {
            throw new NullPointerException("The player must exist");
        }
    }
}
