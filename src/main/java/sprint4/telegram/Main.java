package sprint4.telegram;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int REQUEST_LIMIT = 5;
    private static final int THREAD_LIMIT = 3;
    private static final TelegramBot BOT = new TelegramBot(REQUEST_LIMIT, System.currentTimeMillis());
    private static final String format = "Message number: %d";

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_LIMIT);
        for (int i = 0; i < 100; i++) {
            int num = i;
            service.execute(() -> BOT.sendMessage(String.format(format, num)));
        }
        service.shutdown();
    }
}
