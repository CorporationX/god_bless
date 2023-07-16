package faang.school.godbless.telegram.bot;

import java.util.ArrayList;
import java.util.List;

public class Telegram {

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            Thread thread = new Thread(() -> bot.sendMessage("Xo-xo-xo " + Thread.currentThread().getId()));

            thread.start();
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("All messages sent!");
    }
}
