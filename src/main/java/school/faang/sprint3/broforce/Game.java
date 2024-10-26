package school.faang.sprint3.broforce;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object totalScoreCounterLoc = new Object();
    private final Object livesLostLoc = new Object();
    private List<Bro> bros = new ArrayList<>();
    private Random random = new Random();

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public boolean update() {

        int broIndex = random.nextInt(bros.size());
        Bro bro = bros.get(broIndex);
        boolean isAlive = bro.getAlive();
        if (!isAlive) {
            synchronized (livesLostLoc) {
                bro.setLives(bro.getLives() - 1);
                lives++;
                System.out.println(bro.getName() + "Жизнь" + bro.getLives());
                if (bro.getLives() == 0) {
                    gameOver();
                }
            }

        } else {
            synchronized (totalScoreCounterLoc) {
                bro.setScore(bro.getScore() + 1);
                score++;
            }
        }
        return false;
    }

    public void gameOver() {
        System.out.println(" Все жизни потеряны " + score);
        System.out.println(" Игра окончена ! " + lives);

    }
}
