package faang.school.godbless.telegrambot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService service = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 50; i++){
            int messageNum = i;
            service.execute(() -> bot.messageHandler("message" + messageNum));
        }
        try {
            service.awaitTermination(15, TimeUnit.SECONDS);
            System.out.println("Messages sent");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
