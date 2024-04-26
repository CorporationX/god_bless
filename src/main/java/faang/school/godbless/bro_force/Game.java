package faang.school.godbless.bro_force;

import lombok.Getter;

@Getter
public class Game {
    private int score;
    private int live;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean isGameOver;

    public Game() {
        this.score = 0;
        this.live = 3;
        this.isGameOver = false;
    }

    public void update(){
        synchronized (scoreLock){
            score++;
        }
        synchronized (livesLock){
            if (live <= 0){
                gameOver();
            }
            else {
                live--;
            }
        }
    }

    public void gameOver(){
        System.out.println("Игра закончена");
        isGameOver = true;
    }

    public int getScore(){
        synchronized (scoreLock){
            return score;
        }
    }

    public int getLives(){
        synchronized (livesLock){
            return live;
        }
    }
}
