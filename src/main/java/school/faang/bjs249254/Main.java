package school.faang.bjs249254;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        TelegramBot bot = new TelegramBot();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            service.execute(() -> bot.sendMessage("message: " + finalI));
        }
        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);
    }

}
