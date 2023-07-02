package Multithreading.bc2621;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        List<Message> messages = List.of(new Message("Hello"), new Message("Privet"),
                new Message("Buy"), new Message("How are you"), new Message("I'm fine"));

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new TelegramBot(messages.get(i), i+3, System.currentTimeMillis()));
        }
        executorService.shutdown();
        Thread.sleep(3000);
        System.out.println("Task is done");
    }
}
