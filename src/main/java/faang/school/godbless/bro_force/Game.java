package faang.school.godbless.bro_force;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    private List<Player> players = new ArrayList<>();
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private Random random = new Random();
    private int score = 0;
    private int lives;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean update() {
        int playerIndex = random.nextInt(players.size());
        Player player = players.get(playerIndex);
        boolean isAlive = player.getAlive();

        if (!isAlive) {
            synchronized (livesLock) {
                player.setLives(player.getLives() - 1);
                lives++;
                System.out.println(player.getName() + " current lives = " + player.getLives());
                if (player.getLives() == 0) {
                    player.setAlive(false);
                    return gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                player.setScore(player.getScore() + 1);
                score++;
            }
        }
        return false;
    }

    private boolean gameOver() {
        System.out.println("Game over with max score: " + score);
        System.out.println("Lost lives: " + lives);
        return true;
    }

    public boolean anyOneDead() {
        long count = players.stream()
                .filter(player -> !player.isAlive())
                .count();
        return count > 0;
    }
}