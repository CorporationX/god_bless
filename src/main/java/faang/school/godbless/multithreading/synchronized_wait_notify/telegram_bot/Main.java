package faang.school.godbless.multithreading.synchronized_wait_notify.telegram_bot;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(new Random().nextLong(2000) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int finalI = i;
            Thread thread = new Thread(() -> bot.sendMessage("hello " + finalI));
            thread.start();
        }
    }
}
