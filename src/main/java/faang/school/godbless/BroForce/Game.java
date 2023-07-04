package faang.school.godbless.BroForce;

import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean gameIsNotOver = true;
    private List<Bro> bros;

    public Game(List<Bro> bros) {
        this.bros = bros;
    }

    public void update(int i) {
        int randomIndex = new Random().nextInt(bros.size());

        if (new Random().nextBoolean()) {
            synchronized (livesLock) {
                List<Integer> playerLives = bros.stream().mapToInt(Bro::getLives).boxed().toList();
                if (playerLives.stream().allMatch(live -> live > 0)) {
                    bros.get(randomIndex).decrementLives();
                    lives++;
                } else {
                    gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                bros.get(randomIndex).incrementScore();
                score++;
            }
        }

        if (gameIsNotOver){
            bros.forEach(bro -> {
                System.out.printf("Bro: %s | Score: %s | Lives: %s \n", bro.getName(), bro.getScore(), bro.getLives());
            });
            System.out.println("Round #" + i + "\n");
        }
    }

    private void gameOver() {
        gameIsNotOver = false;
        System.out.println("Game over");
    }
}
