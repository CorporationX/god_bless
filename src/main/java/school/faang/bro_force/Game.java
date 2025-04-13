package school.faang.bro_force;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private static int score;
    private static int lives;
    private static final List<Player> players = Collections.synchronizedList(new ArrayList<>());
    public static Object lockLives = new Object();
    public static Object lockScore = new Object();

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
            System.out.println("Общий счет изменился и сейчас равен: " + score);
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
            System.out.println("Общее количество потерянных жизней изменилось и сейчас равно: " + lives);
        }
    }
}
