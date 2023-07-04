package faang.school.godbless.skyNet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkyNet {
    public static void main(String[] args) {
        Robot firstRobot = new Robot(new Target("firstEnemy"));
        Robot secondRobot = new Robot(new Target("SecondEnemy"));
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(firstRobot::attack);
        executor.submit(secondRobot::attack);

        executor.shutdown();
    }

}
