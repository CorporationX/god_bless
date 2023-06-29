package faang.school.godbless.broforce;

import lombok.Getter;

@Getter
public class Game{
    private volatile int score;
    private volatile int lives;
    final Object lockForScore = new Object();
    final Object lockForLives = new Object();

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update(){
        synchronized (lockForScore){
            if (lives == 0){
                System.out.println("Игра закончена");
                gameOver();
                try {
                    lockForScore.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }

            } else {
                lives--;
                System.out.println("Количество жизней - " + lives);
            }
        }
        synchronized (lockForLives){
            if (lives == 0){
                System.out.println("Игра окончена");
                gameOver();
            } else {
                score++;
                System.out.println("Количество очков - " + score);
            }
        }
    }

    private void gameOver(){
        System.out.println("GameOver");
    }
}
