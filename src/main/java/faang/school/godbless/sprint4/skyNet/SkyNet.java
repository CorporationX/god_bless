package faang.school.godbless.sprint4.skyNet;

import faang.school.godbless.sprint4.skyNet.classes.Robot;
import faang.school.godbless.sprint4.skyNet.classes.Target;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkyNet {
    private static final int NUM_THREAD = 2;

    public static void main(String[] args) throws InterruptedException {
        Robot firstRobot = new Robot(new Target("Stupid Human"));
        Robot secondRobot = new Robot(new Target("Meatball"));

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREAD);

        service.execute(firstRobot::attack);
        service.execute(secondRobot::attack);

        service.shutdown();
    }
}
