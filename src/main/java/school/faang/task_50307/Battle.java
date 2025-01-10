package school.faang.task_50307;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Battle {
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public Future<Robot> fight(Robot rodot1, Robot rodot2) {

        return executorService.submit(() -> {
            log.info("Started fight between {} and {}", rodot1.name(), rodot2.name());

            int robot1Score = rodot1.attackPower() + rodot1.defensePower();
            int robot2Score = rodot2.attackPower() + rodot2.defensePower();
            Robot winner;

            if (robot1Score > robot2Score) {
                winner = rodot1;
                log.info("Winner - {}", winner.name());
            } else if (robot2Score > robot1Score) {
                winner = rodot2;
                log.info("Winner - {}", winner.name());
            } else {
                winner = new Random().nextBoolean() ? rodot1 : rodot2;
                log.info("Draw, winner chosen at random.Winner - {}", winner.name());
            }

            return winner;
        });
    }

    public void shutdown() {
        executorService.shutdown();;
    }
}
