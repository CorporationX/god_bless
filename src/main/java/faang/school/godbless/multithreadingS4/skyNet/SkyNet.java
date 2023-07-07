package faang.school.godbless.multithreadingS4.skyNet;

import java.util.List;

public class SkyNet {
    public static void main(String[] args) {
        Target target = new Target("Target", 100);
        List<Robot> robots = List.of(
                new Robot("Robot1", 10, target),
                new Robot("Robot2", 20, target)
        );

        List<Thread> threads = robots.stream().map(robot -> new Thread(robot::attack)).toList();
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("State of tagret: " + target.getHealthPoints());
    }
}
