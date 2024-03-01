package faang.school.godbless.starwarsarena3241;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Battle {

    public Future<Robot> fight(Robot robot1, Robot robot2, ExecutorService executor) {
        return executor.submit(() -> {
            System.out.printf("Fight begins. %s VS %s%n", robot1.getName(), robot2.getName());
            return new ArrayList<>(List.of(robot1, robot2)).stream()
                    .sorted(Comparator.comparingInt(Robot::getTotalPower).reversed())
                    .collect(Collectors.toList())
                    .get(0);
        });
    }
}
