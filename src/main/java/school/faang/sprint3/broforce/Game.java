package school.faang.sprint3.broforce;

public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object totalScoreCounterLoc = new Object();
    private final Object livesLostLoc = new Object();


    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (totalScoreCounterLoc) {
            if (earnedPoints) {
                score++;
                System.out.println("Очки увеличены, текущий счет: " + score);
            }
        }
        synchronized (livesLostLoc) {
            if (lostLife ) {
                lives--;
                System.out.println("Жизн уменьшены, оставшиеся жизни: " + lives);
                gameOver();
            }

        }

    }


    public void gameOver() {
        if (lives <= 0) {
            System.out.println("Игра окончена! Все жизни потеряны" + score);
        }
    }
}
