package faang.school.godbless.BJS213131;

import lombok.Getter;

@Getter
public class Gamer {
    private static int scoreTotal;
    private static int livesTotal;
    private static boolean isSomebodyDeath;
    private int score;
    private int lives;
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
        synchronized (Gamer.class) {
            score += 1;
            if (!isSomebodyDeath) {
                scoreTotal += 1;
                System.out.println("Gamer " + name + " kill enemy. Now he has " + score + " scores");
                System.out.println("Total scores: " + scoreTotal);
            }
        }
    }

    public synchronized void takeDamage() {
        synchronized (Gamer.class) {
            lives -= 1;
            livesTotal -= 1;
            System.out.println("Gamer " + name + " killed by enemy. Now he has " + lives + " lives");
            System.out.println("Total lives: " + livesTotal);

            if (lives == 0) {
                System.out.println("Gamer " + name + " dead");
                isSomebodyDeath = true;
            }
        }
    }

    public boolean checkDeathGamers() {
        return isSomebodyDeath;
    }
}
