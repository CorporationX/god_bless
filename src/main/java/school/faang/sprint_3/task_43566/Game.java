package school.faang.sprint_3.task_43566;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private int score;
    private int lives;
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void update(boolean getPoint, boolean lostLife) {
        Player player = players.get(new Random().nextInt(players.size()));

        synchronized (scoreLock) {
            if (player.isAlive()) {
                if (getPoint) {
                    player.setScore(player.getScore() + 1);
                    score++;
                    System.out.println("Количество очков " + player.getName() + " увеличено. Общий счет: "
                            + player.getScore());
                }
            } else {
                System.out.println(player.getName() + " уже закончил игру.");
            }
        }
        synchronized (livesLock) {
            if (lostLife) {
                if (player.isAlive()) {
                    player.setLives(player.getLives() - 1);
                    lives++;
                    if (player.getLives() <= 0) {
                        gameOver(player);
                    } else {
                        System.out.println(player.getName() + " потерял жизнь! Осталось: " + player.getLives());
                    }
                } else {
                    System.out.println(player.getName() + " уже закончил игру.");
                }
            }
        }
    }

    private void gameOver(Player player) {
        player.setAlive(false);
        System.out.println(player.getName() + " закончил игру. Собрано очков: " + player.getScore());
    }
}