package faang.school.godbless.skyNet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkyNet {
    public static void main(String[] args) {
        Robot firstRobot = new Robot(1, "First target");
        Robot secondRobot = new Robot(2, "Second target");
        Robot thirdRobot = new Robot(3, "First target");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(firstRobot::attack);
        executorService.execute(secondRobot::attack);
        executorService.execute(thirdRobot::attack);

        executorService.shutdown();
    }
}
