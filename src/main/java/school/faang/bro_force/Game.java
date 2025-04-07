package school.faang.bro_force;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int score;
    private static int lives;
    private static String name;
    private static List<Player> players = new ArrayList<>();
    public static Object lockLives = new Object();
    public static Object lockScore = new Object();

    public Game(String name) {
        this.name = name;
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static void updateScore() {
        for (Player player : players) {
            while (!player.isScoreChanged()) {
                synchronized (lockScore) {
                    try {
                        lockScore.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            score += player.getLastChange();
        }
    }

    public static void updateLives() {
        for (Player player : players) {
            while (!player.isDead()) {
                synchronized (lockLives) {
                    try {
                        lockLives.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            lives -= 1;
        }
    }
}
