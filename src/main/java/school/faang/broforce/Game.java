package school.faang.broforce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private Object scoreLock = new Object();
    private Object livesLock = new Object();
    private int score = 0;
    private int lives = 10;
    private boolean isPlaying = true;

    public void update(boolean earnedPoints, boolean lostLives) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                setScore(getScore() + 1);
                System.out.println("Счет увеличен: " + getScore());
            }
            if (getScore() >= 20) {
                gameOver();
            }
        }

        synchronized (livesLock) {
            if (lostLives && isPlaying()) {
                setLives(getLives() - 1);
                System.out.println("Осталось жизней: " + getLives());
            }
            if (getLives() < 1) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        if (getLives() == 0) {
            System.out.println("Вы проиграли.\nСчёт: " + score);
            setPlaying(false);
        } else {
            System.out.println("Вы победили!");
            setPlaying(false);
        }
    }
}
