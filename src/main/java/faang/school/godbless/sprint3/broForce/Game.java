package faang.school.godbless.sprint3.broForce;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Game {
    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private final List<Bro> bros;

    public void update(Bro bro) {
        boolean isAlive = bro.isAlive();
        synchronized (lockScore) {
            if (isAlive && isContinue()) {
                score++;
                System.out.printf("Current score: %d%n", score);
            }
        }
        synchronized (lockLives) {
            if (!isAlive && isContinue()) {
                bro.setLives(bro.getLives() - 1);
                System.out.printf("Убит игрок %s, осталось жизней - %d%n", bro.getName(), bro.getLives());
                lives++;
                if (!isContinue()) {
                    gameOver();
                }
            }
        }
    }

    public boolean isContinue() {
        return bros.stream()
                .mapToInt(Bro::getLives)
                .noneMatch(lives -> lives == 0);
    }

    private void gameOver() {
        System.out.printf("Game Over for with max score: %d%n", score);
        System.out.printf("Lost lives: %d%n", lives);
    }
}
