package school.faang.task_49567;

public class Game {
    private int score = 0;
    private int lives = 5;

    final Object flagScore = new Object();
    final Object flagLives = new Object();

    public void update(boolean scoresPoints, boolean losesLife) {

        synchronized (flagScore) {
            if (scoresPoints) {
                score++;
            }
        }

        synchronized (flagLives) {
            if (losesLife) {
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
