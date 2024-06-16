package faang.school.godbless.spaceX;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int NUMS_THREAD = 1;

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUMS_THREAD);
        List<RocketLaunch> plan = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            plan.add(new RocketLaunch("Launch %d" + i, 1000 + 100 * i));
        }
        long before = System.currentTimeMillis();
        planRocketLaunches(plan, executor);
        executor.shutdown();
        try {
            executor.awaitTermination(50, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long after = System.currentTimeMillis();
        System.out.println(after - before);

    }

    private static void planRocketLaunches(List<RocketLaunch> plan, ScheduledExecutorService executor) {
        if (plan.isEmpty() || plan == null) {
            throw new IllegalArgumentException("List not be empty. Main class method planRocketLaunches");
        }
        if (executor == null) {
            throw new IllegalArgumentException("ScheduledExecutorService not be empty. Main class method planRocketLaunches");
        }
        for (RocketLaunch rocket : plan) {
            executor.schedule(rocket::launch, rocket.getTimeLaunch() + 100, TimeUnit.MILLISECONDS);
        }
    }
}
