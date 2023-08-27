package faang.school.godbless.skynet;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkyNet {

    public static void main(String[] args) {
        Target multithreading = new Target("Multithreading");

        Robot pasha = new Robot("Pasha", multithreading);
        Robot ivan = new Robot("Ivan", multithreading);

        List<Robot> robots = List.of(pasha, ivan);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (var robot : robots) {
            executor.execute(robot::attack);
        }

        executor.shutdown();
    }
}
