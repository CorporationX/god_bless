package broForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int score = 0;
    private int wastedLives = 0;
    private List<Bro> bros = new ArrayList<>();
    private Object lockScore = new Object();
    private Random random = new Random();

    public List<Bro> getBros() {
        return bros;
    }

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public void update() throws InterruptedException {
        int broIndex = random.nextInt(bros.size());
        Bro bro = bros.get(broIndex);

        synchronized (lockScore) {
            score += random.nextInt(1, 6);
            System.out.println("score added " + score);
            bro.setLives(bro.getLives() - 1);
            System.out.println("lives of bro " + bro.getName() + " = " + bro.getLives());

            if (bro.getLives() == 0) {
                bros.remove(bro);
            }

            wastedLives++;

            if (bros.isEmpty()) {
                gameOver();
                lockScore.wait();
            }
        }
    }

    public void gameOver() {
        System.out.println("\nGame is over!\nWasted lives: " + wastedLives + "\nScore: " + score);
    }
}
