package faang.school.godbless.BroForce;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Game {
    private int score;
    private int lives;

    private final Object lock = new Object();

    public void update(){
        synchronized(lock){
            if (lives > 0){
                updateScore();
                updateLives();
                checkIfDeath();
            }
        }
    }

    private void updateScore(){
        score++;
    }

    private void updateLives(){
        lives--;
    }

    public int getScore(){
        synchronized(lock){
            return score;
        }
    }

    public int getLives(){
        synchronized(lock){
            return lives;
        }
    }

    private void checkIfDeath(){
        if (lives <= 0){
            gameOver();
        }
    }


    private void gameOver(){
        System.out.println("The game is over");
    }

}
