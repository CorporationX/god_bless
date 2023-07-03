package Multithreading.bc2621;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        List<Message> messages = List.of(new Message("Hello"), new Message("Privet"),
                new Message("Buy"), new Message("How are you"), new Message("I'm fine"), new Message("Hi"),
                new Message("Go"));

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 7; i++) {
            executorService.execute(new TelegramBot(messages.get(i), System.currentTimeMillis()));
        }
        executorService.shutdown();
        Thread.sleep(1000);
        System.out.println("Task is done");
    }
}
