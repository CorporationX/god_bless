package faang.school.godbless.synchronization.broForce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Getter
@Slf4j
public class Player {
    public static final int ROUND_DURATION = 100;
    public static final int MAX_SCORE_POINTS_EARNED_BY_ROUND = 21;
    private final String name;
    private boolean isAlive;
    private int score;

    public Player(String name) {
        isAlive = true;
        score = 0;

        if (name == null || name.isBlank()) {
            this.name = "Guest";
            return;
        }

        this.name = name;
    }

    public void simulateGame() {
        Random randomizer = new Random();

        while (isAlive) {
            try {
                Thread.sleep(ROUND_DURATION);
            } catch (InterruptedException e) {
                log.warn("Player game was interrupted.", e);
            }

            int d20Result = randomizer.nextInt(1, MAX_SCORE_POINTS_EARNED_BY_ROUND);

            if (d20Result == 20) {
                score += d20Result * 2;
                log.info(name + " gained " + 40 + " score points!!! Current score: " + score);
                continue;
            }

            if (d20Result == 1) {
                isAlive = false;
                log.info(name + " died. Total score: " + score);
                continue;
            }

            if (d20Result > 15) {
                score += d20Result;
                log.info(name + " gained " + d20Result + " score points. Current score: " + score);
                continue;
            }

            if (d20Result < 10) {
                if (score - 1 > 0) {
                    score--;

                    log.info(name + " loosed " + 1 + " score point. Current score: " + score);
                }
            }
        }
    }
}
