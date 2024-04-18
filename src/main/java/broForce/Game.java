package broForce;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int GAME_OVER_NUM = 20;
    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private final List<Player> players = new ArrayList<>();

    public void update() {
        synchronized (lockScore) {

            score++;
            System.out.println(score);
        }
        synchronized (lockLives) {

            lives++;
            System.out.println(lives);
        }
    }

    private void gameOver() {

    }

    public void addPlayer(Player player) {
        if (player == null) {
            throw new NullPointerException("The player must exist");
        }
        players.add(player);
    }
}
