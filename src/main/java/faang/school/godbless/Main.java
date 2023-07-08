package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int threadNumber = i;
            Thread thread = new Thread(() -> {
                String message = "Message from thread " + threadNumber;
                bot.sendMessage(message);
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Task completed.");
    }
}
