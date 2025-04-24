package school.faang.bro_force;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

@Slf4j
@Data
@AllArgsConstructor
public class Player {
    private String name;
    private int score;
    private int lives;

    public void play(Game game) {
        if (lives <= 0) {
            System.out.println("Player cannot continue playing, lives <= 0");
            return;
        }
        log.debug("Thread: {}, calling play()", Thread.currentThread().getName());
        Map<Parameter, Function<Integer, Integer>> updates = new HashMap<>();
        makeAMove(updates);
        game.update(updates);
    }

    private void makeAMove(Map<Parameter, Function<Integer, Integer>> updates) {
        switch (ThreadLocalRandom.current().nextInt(2)) {
            case 0: {
                log.debug("Thread: {}, Player won", Thread.currentThread().getName());
                score++;
                updates.put(Parameter.SCORE, score -> score + 1);
                break;
            }
            case 1: {
                log.debug("Thread: {}, Player lost", Thread.currentThread().getName());
                score--;
                lives--;
                if (lives <= 0) {
                    System.out.println("Player cannot continue playing, lives <= 0");
                    return;
                }
                updates.put(Parameter.SCORE, score -> score - 1);
                updates.put(Parameter.LIVE, live -> live - 1);
                break;
            }
            default: {
                break;
            }
        }
    }
}