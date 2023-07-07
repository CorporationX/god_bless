package faang.school.godbless.bro_force;

public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private int score = 5;
    private int lives = 5;

    public synchronized void update(){
        synchronized (scoreLock){
            if (lives > 0){
                lives--;
                System.out.println("Lives: " + lives);
            } else {
                gameOver();
            }
        }

        synchronized (livesLock){
            score++;
            System.out.println("Score: " + score);
        }
    }

    public void gameOver(){
        System.out.println("Game over");
    }
}
