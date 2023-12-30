package faang.school.godbless.BroForce;

import lombok.Getter;

import java.util.Random;

@Getter
public class Game {
    private static int score;      // счётчик набранных очков за игру всеми участниками
    private static int lives;      // количество потерянных всеми участниками жизней
    private static final Object lockScore = new Object();
    private static final Object lockLives = new Object();
    //static List<Player> players = new ArrayList<>();

    public void update(Player player) {
        if (player.isAlive()) {
            if (player.getLive() > 0) {
                Random random = new Random();
                boolean alive = random.nextBoolean();
                if (alive) {
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
                }
            }
        }
    }

    private void gameOver(Player player) {
        System.out.println("Iгрок " + player.getName() + " умер в жестоком бою");
        System.out.println("Потерянные жизни: " + lives);
        System.out.println("Очки за игру: " + score);
        player.setAlive(false);
    }
}

