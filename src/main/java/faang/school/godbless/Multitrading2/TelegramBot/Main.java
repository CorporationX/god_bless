package faang.school.godbless.Multitrading2.TelegramBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(() -> bot.sendMessage("Message"));
        service.execute(() -> bot.sendMessage("Message1"));
        service.execute(() -> bot.sendMessage("Message2"));
        service.execute(() -> bot.sendMessage("Message3"));
        service.execute(() -> bot.sendMessage("Message4"));
        service.shutdown();
    }
}
