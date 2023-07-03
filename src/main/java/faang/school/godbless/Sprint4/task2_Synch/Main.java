package faang.school.godbless.Sprint4.task2_Synch;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(0, 1000);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread
                    (() -> telegramBot.sendMessage("thread number " + Thread.currentThread().getId() + " completed"));
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
