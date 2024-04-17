package faang.school.godbless.BroForce;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class Game {
    private final Random random = new Random();
    public final Object scoreLock = new Object();
    public final Object livesLock = new Object();
    private final List<Bro> players = new ArrayList<>();
    private int score = 0;
    private int lives = 0;

    public void addBro(Bro bro) {
        players.add(bro);
    }

    public boolean update() {
        Bro bro = players.get(random.nextInt(players.size()));
        int action = random.nextInt(2);
        if (action == 0) {
            synchronized (scoreLock) {
                score++;
            }
        } else {
            synchronized (livesLock) {
                lives++;
                bro.decreaseLives();
                if (!bro.isAlive()) {
                    System.out.println(bro.getName() + " died");
                    return gameOver();
                }
            }
        }
        return true;
    }

    private boolean gameOver() {
        System.out.println("Total score: " + score);
        System.out.println("Total lives: " + lives);
        return false;
    }
}
