package school.faang.BJS2_37202;

public class Game {
    private int score = 0;
    private int lives = 9;

    private final Object lockScore= new Object();
    private final Object lockLives= new Object();

    public void update(boolean earnedPoint, boolean loseLife) {
        synchronized (lockScore) {
            if (earnedPoint) {
                score++;
                System.out.println("Очки увеличены, текущий счет: " + score);
            }
        }
        synchronized (lockLives) {
            if (loseLife) {
                lives--;
                System.out.println("Жизни уменьшены, текущее количество жизней: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    public void gameOver() {
        System.out.println("Game Over!. Вы проиграли!");
        System.out.println("Финальный счет: " + score);
    }
}
