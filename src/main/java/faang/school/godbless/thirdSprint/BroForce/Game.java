package faang.school.godbless.thirdSprint.BroForce;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Game {
    private final Object lock = new Object();
    private boolean isGameContinues;
    private int score;
    private int lives;

    public Game() {
        isGameContinues = true;
        score = 0;
        lives = 5;
    }

    public synchronized void update() {
        if (lives > 0) {
            int randomNum = ThreadLocalRandom.current().nextInt(2);
            if (randomNum == 0) {
                lives--;
                if (lives == 0) {
                    gameOver();
                } else {
                    System.out.println("You lost one life. Be careful! Now you have " + lives + " lives");
                }
            } else {
                score++;
                System.out.println("You earned one point. Good work! Now you have " + score + " points.");
            }
        }
    }

    private synchronized void gameOver() {
        if (isGameContinues) {
            System.out.println("You died, game is over! You have earned " + score + " points in this game.");
            isGameContinues = false;
        }
    }
}
