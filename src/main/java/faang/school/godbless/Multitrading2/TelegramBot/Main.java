package faang.school.godbless.Multitrading2.TelegramBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService service = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 20; i++) {
            service.execute(() -> bot.sendMessage("Message"));
        }
        service.shutdown();
    }
}
