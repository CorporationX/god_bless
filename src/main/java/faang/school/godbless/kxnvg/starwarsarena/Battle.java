package faang.school.godbless.kxnvg.starwarsarena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        Robot[] robots = new Robot[]{robot1, robot2};
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Robot> futureResultOfFight = service.submit(() -> robots[new Random().nextInt(2)]);
        service.shutdown();
        return futureResultOfFight;
    }
}
