package school.faang.Sprints.Multithreading_Synchronization.bro_force;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Game {
    private int score = 0;
    private int lives = 5;
    private boolean isGame = true;

    private Object scoreLock = new Object();
    private Object livesLock = new Object();

    public void update(boolean earnedPoints, boolean lostLife) {

        synchronized (scoreLock) {
            if (earnedPoints) {
                System.out.println(Thread.currentThread().getName() + " score " + score + " +1");
                score++;
            }
        }

        synchronized (livesLock) {
            if (lives == 0) {
                gameOver();
            }

            if (lostLife) {
                System.out.println(Thread.currentThread().getName() + " lives " + lives + " -1");
                lives--;
            }
        }
    }

    private synchronized void gameOver() {
        System.out.println("GAME OVER");
        try {
            isGame = false;
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
