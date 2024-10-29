package school.faangSprint4.t23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    private static final int SLEEP_TIME = 1000;

    public static void main(String[] args) throws InterruptedException {
        MilitaryBase base1 = new MilitaryBase("Base Alpha");
        MilitaryBase base2 = new MilitaryBase("Base Beta");

        ExecutorService executorService = Executors.newCachedThreadPool();

        startBases(executorService, base1, base2);
        sendMessages(base1, base2);
        stopBases(base1, base2);
        shutdownExecutor(executorService);
    }

    private static void startBases(ExecutorService executorService, MilitaryBase... bases) {
        for (MilitaryBase base : bases) {
            executorService.submit(base);
        }
    }

    private static void sendMessages(MilitaryBase base1, MilitaryBase base2) throws InterruptedException {
        base1.sendMessage(base2, "Hello from Base Alpha!");
        Thread.sleep(SLEEP_TIME);

        base2.sendMessage(base1, "Greetings, Base Alpha!");
        Thread.sleep(SLEEP_TIME);

        base1.sendMessage(base2, "Mission accomplished!");
        Thread.sleep(SLEEP_TIME);
    }

    private static void stopBases(MilitaryBase... bases) {
        for (MilitaryBase base : bases) {
            base.stop();
        }
    }
    private static void shutdownExecutor(ExecutorService executorService) throws InterruptedException {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
