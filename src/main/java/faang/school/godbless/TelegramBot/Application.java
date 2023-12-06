package faang.school.godbless.TelegramBot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        TelegramBot bot = new TelegramBot();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            int j = i;
            threadList.add(new Thread(() -> {
                bot.sendMessage("Message " + j);
            }));
        }

        for (Thread thread : threadList) {
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println("Task completed.");

    }
}
