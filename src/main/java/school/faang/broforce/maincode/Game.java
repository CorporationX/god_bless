package school.faang.broforce.maincode;

public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private int score = 0;
    private int lives = 10;

    public void update(boolean scorePoints, boolean loseLife) {
        synchronized (scoreLock) {
            if (scorePoints) {
                score++;
                System.out.println("Вы набрали поинт " + score);
            }
        }

        synchronized (livesLock) {
            if (loseLife) {
                lives--;
                System.out.println("Вы потеряли жизнь " + lives);

                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    public void gameOver() {
        System.out.println("Игра завершена вы набрали " + score + " очков");
        System.exit(0);
    }
}
