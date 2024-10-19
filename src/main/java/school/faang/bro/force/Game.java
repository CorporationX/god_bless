package school.faang.bro.force;

public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(int lives) {
        this.lives = lives;
        score = 0;
    }

    public void update(Update update) {
        if (update == null) {
            return;
        }
        synchronized (scoreLock) {
            synchronized (livesLock) {
                if (lives <= 0) {
                    gameOver();
                    return;
                }
                if (update.isScoredPoints()) {
                    score++;
                    System.out.println("Общее кол-во очков увеличено: " + score);
                }
                if (update.isSpentLives()) {
                    lives--;
                    System.out.println("Общее кол-во жизней уменьшено: " + lives);
                    if (lives <= 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра окончена! Набранное кол-во очков: " + score);
    }
}
