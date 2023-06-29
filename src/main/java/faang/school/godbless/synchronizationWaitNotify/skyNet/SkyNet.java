package faang.school.godbless.synchronizationWaitNotify.skyNet;

import java.util.ArrayList;
import java.util.List;

public class SkyNet {
    private static final int NUMBER_OF_THREADS = 2;

    public static void main(String[] args) {
        List<Robot> robots = List.of(
                new Robot("Bob", new Target("target1")),
                new Robot("Alex", new Target("target2"))
        );

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threadList.add(new Thread(robots.get(i)::attack));
            threadList.get(i).start();
        }
    }
}
