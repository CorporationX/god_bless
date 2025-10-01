package bjs2_92649;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Battle {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return executor.submit(() -> {
            int firstRobotPower = firstRobot.getTotalPower();
            int secondRobotPower = secondRobot.getTotalPower();

            System.out.printf("Битва: %s VS %s%n", firstRobot.getName(), secondRobot.getName());

            if (firstRobotPower > secondRobotPower) {
                return firstRobot;
            } else if (secondRobotPower > firstRobotPower) {
                return secondRobot;
            } else {
                return Math.random() > 0.5 ? firstRobot : secondRobot;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}