package faang.school.godbless.multithreading.synchronized_wait_notify.telegram_bot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int finalI = i;
            Thread thread = new Thread(() -> bot.sendMessage("hello " + finalI));
            thread.start();
        }



//        ExecutorService executor = Executors.newFixedThreadPool(100);

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                int msgIndex = j;
//                executor.execute(() -> {
//                    bot.sendMessage("hello " + msgIndex);
//                });
//            }
//        }
//        executor.shutdown();
    }
}
