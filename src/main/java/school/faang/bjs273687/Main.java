package school.faang.bjs273687;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game(11);

        for (int i = 0; i < 100; i++) {
            if (game.isFinished()) {
                break;
            }
            boolean isLiveLost = Math.random() < 0.2;
            boolean isScoreEarned = Math.random() < 0.5;

            new Thread(() -> game.update(isLiveLost, isScoreEarned)).start();
        }
    }
}
