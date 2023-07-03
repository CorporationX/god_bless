package faang.school.godbless.Bot;

import lombok.SneakyThrows;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(Instant.now());
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i ++){
            int finalI = i;
            var thread = new Thread(() -> bot.sendMessage(Integer.toString(finalI)));
            thread.start();
            threads.add(thread);
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        System.out.println("Done");
    }
}
