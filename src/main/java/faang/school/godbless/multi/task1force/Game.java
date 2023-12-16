package faang.school.godbless.multi.task1force;

public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean gameIsOver = false;

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    // что сделано грамотнее update1 или update2? или разницы нет? или есть еще вариант?
    public synchronized void update1() {
        if (gameIsOver) {
            return;
        }

        score++;
        lives--;
        System.out.println("Score: " + score + ", Lives: " + lives);

        if (lives == 0) {
            gameOver();
            //return; здесь работает иначе, почему так? без него счетчик жизней уходит в минус
            // а с ним вместо этого постоянно пишет game over, но метод не завершается
            //решил проблему флагом gameIsOver
        }
    }

    public void update2() {
        if (gameIsOver) {
            return;
        }

        synchronized (scoreLock) {
            score++;
        }

        synchronized (scoreLock) {
            lives--;
            System.out.println("Score: " + score + ", Lives: " + lives);
        }

        if (lives == 0) {
            gameOver();
        }
    }

    private void gameOver() {
        gameIsOver = true;
        System.out.println("Game Over!");
    }
}
