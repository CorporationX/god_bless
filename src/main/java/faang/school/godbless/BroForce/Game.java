package faang.school.godbless.BroForce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private static int score;      // счётчик набранных очков за игру всеми участниками
    private static int lives;      // количество потерянных всеми участниками жизней
    private static Object lockScore = new Object();
    private static Object lockLives = new Object();
    static List<Player> players = new ArrayList<>();

    public static void update(Player player) throws InterruptedException {
        synchronized (lockScore) {
            if (player.isAlive()) {
                score++;
                System.out.println("Очки за игру: " + score + " в потоке " + Thread.currentThread().getName());
            }
        }
        synchronized (lockLives) {
            player.setLive(player.getLive() - 1);
            lives++;
            System.out.println("Потерянные жизни: " + lives + " в потоке " + Thread.currentThread().getName());
            if (player.getLive() == 0)
                gameOver(player);
        }
    }

    private static void gameOver(Player player) {
        System.out.println("Iгрок " + player.getName() + " умер в жестоком бою");
        player.setAlive(false);
    }

}
