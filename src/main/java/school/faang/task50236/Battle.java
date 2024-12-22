package school.faang.task50236;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@Slf4j
public class Battle {
    public CompletableFuture<Robot> fight(Robot robot1, Robot robot2) {
        return CompletableFuture.supplyAsync(() -> {
            Robot robotWinner = Stream.of(robot1, robot2)
                    .max(Comparator.comparing(robot
                            -> robot.defensePower() + robot.attackPower()))
                    .get();

            log.info("Победил робот: {}", robotWinner.name());

            return robotWinner;
        });
    }
}
