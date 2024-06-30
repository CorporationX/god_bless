package faang.school.godbless.broforce;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Integer score;
    private Integer lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    public void gameOver() {
        System.out.println("Game is over!!!");
    }

    public Game(Integer score, Integer lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update() throws InterruptedException {
        System.out.println("scores "+score);
        System.out.println("lives "+lives);
        synchronized (lockScore) {
            score-=1;
            System.out.println("Scores after "+score);
            synchronized (lockLives) {
                lockScore.wait();
                if(lives>0){
                    lives-=1;
                    System.out.println("Lives after "+lives);
                } else {
                    gameOver();
                }
            }
            lockScore.notify();

        }

    }
}
