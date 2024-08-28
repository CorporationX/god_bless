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
    private boolean gameOver = false;
    private int score = 0;
    private int lives;

    public Game(List<Player> players) {
        this.lives = players.stream().mapToInt(player -> player.getLives()).sum();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void update() {
        if (gameOver) {
            return;
        }

        int playerIndex = random.nextInt(players.size());
        Player player = players.get(playerIndex);
        boolean isAlive = player.getAlive();

        synchronized (this) {
            if (player.getLives() == 0) {
                player.killing();
            }

            if (player.getAlive()) {
                if (!isAlive) {
                    synchronized (livesLock) {
                        player.setLives(player.getLives() - 1);
                        lives--;
                        System.out.println("Осталось жизней " + lives);
                    }
                } else {
                    synchronized (scoreLock) {
                        player.setScore(player.getScore() + 1);
                        score++;
                        System.out.println("Количество очков " + score);
                    }
                }
            }

            if (player.getLives() <= 0) {
                gameOver();
            }
        }
    }

    private synchronized void gameOver() {
        if (gameOver) {
            return;
        }
        gameOver = true;
        System.out.println("Game over, max score " + score);
        System.out.println("Lost lives " + lives);
    }
}