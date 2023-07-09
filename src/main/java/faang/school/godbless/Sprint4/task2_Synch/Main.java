package faang.school.godbless.Sprint4.task2_Synch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(0, LocalDateTime.now());

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Thread thread = new Thread
                    (() -> telegramBot.sendMessage("thread number " + Thread.currentThread().getName() + " completed"));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All messages have been sent");
    }
}
