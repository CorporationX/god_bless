package school.faang.java.thread1.broforce;

import java.util.concurrent.ExecutorService;

public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object monitorScore = new Object();
    private final Object monitorLive = new Object();

    public int getScore() {
        synchronized (monitorScore) {
            return score;
        }
    }

    public void setScore(int score) {
        synchronized (monitorScore) {
            this.score = score;
        }
    }

    public int getLives() {
        synchronized (monitorLive) {
            return lives;
        }
    }

    public void setLives(int lives) {
        synchronized (monitorLive) {
            this.lives = lives;
        }
    }

    public boolean update(boolean isScoreIncreased, boolean isLiveDecreased, User user, ExecutorService executorService){
        /*
        if (isScoreIncreased){
            System.out.printf("\nEnter ==isScoreIncreased== user: %s", user.name());
            synchronized (monitorScore){
                System.out.printf("\nEnter =isScoreIncreased synchronized= user: %s", user.name());
                Util.workingProcess(30);
                score++;
            }
        } */
       if(isLiveDecreased){
            System.out.printf("\nEnter ==isLiveDecreased== user: %s", user.name());
            synchronized (monitorLive){
                System.out.printf("\nEnter = isLiveDecreased synchronized= user: %s", user.name());
                lives--;
                System.out.printf("\nLives =  %d", lives);
                Util.workingProcess(30);
                if(lives<1){
                    gameOver(executorService);
                    return false;
                }
                System.out.printf("\nEnter =EXIT isLiveDecreased synchronized= user: %s", user.name());
            }
        }
        return true;
    }

    private void gameOver(ExecutorService executorService){
        System.out.printf("\nGame Over. Score : %d /// Live: %d", score, lives);
        executorService.shutdownNow();
    }
}