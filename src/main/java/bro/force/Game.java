package bro.force;

public class Game {
    private int score;
    private int lives;
    private final Object soreLocker = new Object();
    private final Object livesLocker = new Object();

    public void update(boolean playerScore, boolean playerLostLife) {
        synchronized (soreLocker) {
            if (playerScore) {
                score++;
                System.out.println("Очки увеличены");
            }
        }
        synchronized (livesLocker) {
            if (playerLostLife) {
                lives--;
                System.out.println("Жизни уменьшены");
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Конец игры! Ваш общий счет за игру: " + score);
    }
}
