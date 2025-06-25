package school.faang.bjs2_81812;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 50; i++) {
            int finalI = i;
            executor.submit(() -> bot.sendMessage("Hello from thread " + finalI));
        }

        executor.shutdown();
    }
}
