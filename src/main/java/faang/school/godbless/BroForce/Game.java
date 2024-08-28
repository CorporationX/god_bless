package faang.school.godbless.BroForce;

import java.util.Random;

public class Game {
    private int scores = 0;
    private int lives = 0;

    private final Object scoreLock = new Object();
    private final Object liveLock = new Object();

    public void update(Bro attacker, Bro defender) {
        handleLives(attacker, defender);
        updateScores();
        checkGameOver(attacker, defender);
    }

    private void handleLives(Bro attacker, Bro defender) {
        synchronized (liveLock) {
            Bro target = new Random().nextBoolean() ? attacker : defender;
            target.decreaseLives();
            System.out.println(target.getName() + " lost a life. Remaining lives: " + target.getLives());
            if (target.isAlive()) {
                lives++;
                System.out.println("Lives updated: " + lives);
            }
        }
    }

    private void updateScores() {
        synchronized (scoreLock) {
            scores++;
            System.out.println("Score updated: " + scores);
        }
    }

    private void checkGameOver(Bro attacker, Bro defender) {
        if (!attacker.isAlive() || !defender.isAlive()) {
            gameOver();
        }
    }

    private void gameOver() {
        System.out.println("The game is over");
        System.out.printf("Was spent " + this.lives + " lives. The result score is " + this.scores);
    }
}