package Multithreading.bc2621;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        List<Message> messages = new ArrayList<>();
        for(int i = 1; i <= 25; i++){
            messages.add(new Message("Message" + i));
        }
        TelegramBot telegramBot = new TelegramBot();

        ExecutorService executorService = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 25; i++) {
            int finalI = i;
            executorService.execute(
                    () -> {
                        try {
                            telegramBot.sendMessage(messages.get(finalI));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        }
        executorService.shutdown();
        boolean isFinished = executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
        if (isFinished) {
            System.out.println("Task is done");
        }
    }
}
