package school.faang.task_49567;

public class Game {
    private int score = 0;
    private int lives = 5;

    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public void update(boolean scoresPoints, boolean losesLife) {

        if (scoresPoints) {
            synchronized (lockScore) {
                score++;
            }
        }

        if (losesLife) {
            synchronized (lockLives) {
                lives--;
            }

            if (lives <= 0) {
                gameOver();
            }
        }

        System.out.println("Finish update score = " + score + ", lives = " + lives);
    }

    private void gameOver() {
        System.out.println("Game over!!!");
    }
}
