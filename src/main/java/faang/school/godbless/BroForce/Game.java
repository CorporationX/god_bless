package faang.school.godbless.BroForce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    private static int score;      // счётчик набранных очков за игру всеми участниками
    private static int lives;      // количество потерянных всеми участниками жизней
    private static final Object lockScore = new Object();
    private static final Object lockLives = new Object();
    private static int countPlayers = 0;
    static List<Player> players = new ArrayList<>();

    public boolean update(Player player) {
        if (player.isAlive() && (players.size() - countPlayers) > 1) {
            Random random = new Random();
            boolean action = random.nextBoolean();
            if (action) {
                synchronized (lockScore) {
                    if (player.isAlive()) {
                        player.setScore(player.getScore() + 1);
                        System.out.println("Очки " + player.getName() + ": " + player.getScore());
                        score++;
                    }
                }
            } else {
                synchronized (lockLives) {
                    player.setLive(player.getLive() - 1);
                    System.out.println("Оставшееся количество жизней у игрока " + player.getName() + ": " + player.getLive());
                    lives++;
                    if (player.getLive() == 0)
                        gameOver(player);
                }
            } return true;
        } else {
            System.out.println(player.getName() + " победил");
            return false;
        }
    }

    private void gameOver(Player player) {
        System.out.println("Iгрок " + player.getName() + " умер в жестоком бою");
        System.out.println("Потерянные жизни: " + lives);
        System.out.println("Очки за игру: " + score);
        player.setAlive(false);
        countPlayers++;
    }
}

