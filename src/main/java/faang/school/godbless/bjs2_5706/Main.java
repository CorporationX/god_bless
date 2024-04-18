package faang.school.godbless.bjs2_5706;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TelegramBot telegramBot = new TelegramBot();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.execute(() -> telegramBot.sendMessage("Message-" + finalI));
            Thread.sleep(10);
        }

        executorService.shutdown();

        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
