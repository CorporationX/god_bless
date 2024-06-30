package faang.school.godbless.BJS213131;

import lombok.Getter;

public class Gamer {
    @Getter
    private static int scoreTotal;
    @Getter
    private static int livesTotal;
    private int score;
    private int lives;
    @Getter
    private String name;
    private boolean isAlive;
    public Gamer(String name) {
        isAlive = true;
        this.name = name;
        lives += 3;
        synchronized (Gamer.class) {
            livesTotal += 3;
        }
    }

    public synchronized void killEnemy() {
        if (!isAlive) {
            System.out.println("Gamer " + name + " already dead");
            return;
        }
        score += 1;
        synchronized (Gamer.class) {
            scoreTotal += 1;
            System.out.println("Gamer " + name + " kill enemy. Now he has " + score + " scores");
            System.out.println("Total scores: " + scoreTotal);
        }
    }

    public synchronized boolean isGameContinueAfterDeath() {
        if (!isAlive) {
            System.out.println("Gamer " + name + " already dead");
        } else {
            lives -= 1;
            synchronized (Gamer.class) {
                livesTotal -= 1;
                System.out.println("Gamer " + name + " killed by enemy. Now he has " + lives + " lives");
                System.out.println("Total lives: " + livesTotal);

                if (lives == 0) {
                    System.out.println("GAME OVER! Thanks " + name);
                    return false;
                }
            }

        }
        return true;
    }

}
