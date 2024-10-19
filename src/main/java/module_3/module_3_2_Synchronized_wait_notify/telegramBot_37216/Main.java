package module_3.module_3_2_Synchronized_wait_notify.telegramBot_37216;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        List<String> messages = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            messages.add("Hello Java_" + i);
        }

        List<Thread> threads = new ArrayList<>();
        for (String message : messages) {
            threads.add(new Thread(() -> telegramBot.sendMessage(message)));
        }
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("All messages sent");
    }
}
