package faang.school.godbless.BJS2_24317;

public class Game {
    private final Lock lockLives = new Lock();

    private int score;
    private int lives;

    Game(int lives) {
        this.lives = lives;
        this.score = 0;
    }

    public void update() {
        synchronized (lockLives) {
            if (lives > 0) {
                score++;
                lives--;
                System.out.println("Score: " + score + ", Lives: " + lives);

                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over, your score: " + score);
    }
}
