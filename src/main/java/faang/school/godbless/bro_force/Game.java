package faang.school.godbless.bro_force;

public class Game {
    private final Object score_lock = new Object();
    private final Object lives_lock = new Object();
    private int score = 5;
    private int lives = 5;

    public synchronized void update(){
        synchronized (score_lock){
            if (lives > 0){
                lives--;
                System.out.println("Lives: " + lives);
            } else {
                gameOver();
            }
        }
        synchronized (lives_lock){
            score++;
            System.out.println("Score: " + score);
        }
    }

    public void gameOver(){
        System.out.println("Game over");
    }
}
