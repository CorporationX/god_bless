package faang.school.godbless.alexbulgakoff.multithreading.synchronization.broforce;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Alexander Bulgakov
 */
@Getter
@ToString
public class Game {

    private Random random = new Random();
    private long scores;
    private long lives;
    private final List<Player> playerList;

    private final Object scoreLock;
    private final Object liveLock;

    public Game() {
        playerList = new ArrayList<>();
        scoreLock = new Object();
        liveLock = new Object();
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public boolean update() {
        int playerIndex = random.nextInt(playerList.size());
        Player player = playerList.get(playerIndex);
        boolean isAlive = player.isAlive();

        if (!isAlive) {
            synchronized (liveLock) {
                player.damageToPlayer();
                lives++;
                System.out.println("Игрок " + player.getName() + " получает урон!");
                System.out.println("У игрока " + player.getName() + " осталось жизней: " + player.getHealth());

                if (player.getHealth() == 0) {
                    System.out.println("Игрок " + player.getName() + " погиб!");
                    return gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                scores++;
            }
        }
        return false;
    }

    private boolean gameOver() {
        System.out.println("Игра окончена!");
        return true;
    }

}
