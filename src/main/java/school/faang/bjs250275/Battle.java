package school.faang.bjs250275;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    private static final int THREAD_POOL = 3;
    private static final int SLEEP_TIME = 5_000;

    private ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return service.submit(() -> {
            System.out.printf("%s. Battle started between %s and %s%n",
                    Thread.currentThread().getName(), robot1.getName(), robot2.getName());
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
            int power1 = robot1.getAttackPower() + robot1.getDefensePower();
            int power2 = robot2.getAttackPower() + robot2.getDefensePower();
            System.out.printf("%s. Battle ended between %s and %s%n",
                    Thread.currentThread().getName(), robot1.getName(), robot2.getName());
            return power1 > power2 ? robot1 : robot2;
        });
    }

    public void shutdown() {
        System.out.println("Shutting down ExecutorService...");
        service.shutdown();
    }

}
