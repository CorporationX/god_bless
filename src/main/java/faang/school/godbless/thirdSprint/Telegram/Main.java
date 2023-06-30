package faang.school.godbless.thirdSprint.Telegram;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            service.submit(() -> bot.sendMessage("Message №" + finalI));
        }
        service.shutdown();
    }
}
