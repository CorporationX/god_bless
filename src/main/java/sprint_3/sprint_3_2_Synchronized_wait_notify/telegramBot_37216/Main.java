package sprint_3.sprint_3_2_Synchronized_wait_notify.telegramBot_37216;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        List<String> messages = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            messages.add("Hello Java_" + i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        messages.forEach(message -> executorService.submit(() -> telegramBot.sendMessage(message)));
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Thread has bin interrupted {}", e.getMessage());
        }

        System.out.println("All messages sent");
    }
}
