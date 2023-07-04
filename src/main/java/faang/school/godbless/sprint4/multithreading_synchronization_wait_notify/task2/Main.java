package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(System.currentTimeMillis());
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int j = i;
            Thread thread = new Thread(() -> {
                try {
                    telegramBot.sendMessage("Message " + j);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
