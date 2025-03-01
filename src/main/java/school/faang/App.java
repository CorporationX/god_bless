package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class App {
    private static final int WORKING_TIME_MS = 5000;
    private static final int MESSAGE_COUNT = 20;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        MilitaryBase base1 = new MilitaryBase();
        MilitaryBase base2 = new MilitaryBase();

        for (int i = 0; i < MESSAGE_COUNT; ++i) {
            base1.sendMessage(base2, "Message " + i);
        }
        executor.execute(base2);
        try {
            Thread.sleep(WORKING_TIME_MS);
        } catch (InterruptedException e) {
            log.error("Sleep was interrupted.");
            Thread.currentThread().interrupt();
        }
        base2.stop();
        executor.shutdown();
    }
}
