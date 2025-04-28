package school.faang.bjs273687;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final double LOSE_LIFE_PROBABILITY = 0.2;
    private static final double EARN_SCORE_PROBABILITY = 0.5;

    public static void main(String[] args) {
        Game game = new Game(11);

        for (int i = 0; i < 100; i++) {
            if (game.isFinished()) {
                break;
            }
            boolean isLiveLost = Math.random() < LOSE_LIFE_PROBABILITY;
            boolean isScoreEarned = Math.random() < EARN_SCORE_PROBABILITY;

            new Thread(() -> game.update(isLiveLost, isScoreEarned)).start();
        }
    }
}
