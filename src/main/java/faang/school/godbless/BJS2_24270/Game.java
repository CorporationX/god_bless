package faang.school.godbless.BJS2_24270;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Game {
    private int score;
    private int lives;
    private Random random = new Random();
    private List<Bro> bros = new ArrayList<>();

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void addBro(Bro bro) {
        bros.add(bro);
        System.out.println("Добавлен новый Bro: " + bro);
    }

    public boolean update() {
        int broIndex = random.nextInt(bros.size());
        Bro bro = bros.get(broIndex);

        if (!bro.getAlive()) {
            updateLives(bro);
            return bro.getLives() <= 0;
        } else {
            updateScore(bro);
        }

        return false;
    }
    private void updateLives(Bro bro) {
        synchronized (livesLock) {
            bro.setLives(bro.getLives() - 1);
            lives++;
            System.out.println(bro.getName() + " теряет жизнь. Осталось жизней: " + bro.getLives());

            if (bro.getLives() <= 0) {
                bro.setAlive(false);
                System.out.println(bro.getName() + " погиб.");
                gameOver();
            }
        }
    }
    private void updateScore(Bro bro) {
        synchronized (scoreLock) {
            bro.setScore(bro.getScore() + 1);
            score++;
            System.out.println(bro.getName() + " получил очко. Текущий счет: " + bro.getScore());
        }
    }

    private boolean gameOver() {
        System.out.println("GAME OVER");
        System.out.println("Очков в игре: " + score);
        System.out.println("Потерянные жизни: " + lives);
        return true;
    }
}
