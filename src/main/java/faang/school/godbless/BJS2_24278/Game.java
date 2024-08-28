package faang.school.godbless.BJS2_24278;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class Game implements Runnable {
    private final Object scoreLock = new Object();
    private final Object liveLock = new Object();
    private final List<Player> PLAYERS;
    private int score;
    private int lives;
    private boolean isGameOver;

    public void update() {
        int attacker = new Random().nextInt(PLAYERS.size());
        int defender;

        do {
            defender = new Random().nextInt(PLAYERS.size());
        } while (defender == attacker);

        System.out.printf("%s attacks %s%n", PLAYERS.get(attacker).getName(), PLAYERS.get(defender).getName());
        Player.getDamage(PLAYERS.get(defender));

        if (PLAYERS.get(defender).getLives() == 0)
            PLAYERS.remove(defender);

        if (PLAYERS.size() == 1)
            gameOver();
        else {
            synchronized (liveLock) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lives++;
            }
        }

        synchronized (scoreLock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            score++;
        }
    }

    private void gameOver() {
        isGameOver = true;
        System.out.printf("The game is over! Was spent %s lives. The score is %s%n", lives, score);
    }

    @Override
    public void run() {
        while (!isGameOver)
            update();

        System.out.printf("Winner is %s, he has lives: %d", PLAYERS.get(0).getName(), PLAYERS.get(0).getLives());
    }
}