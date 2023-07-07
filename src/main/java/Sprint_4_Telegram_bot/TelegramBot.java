package Sprint_4_Telegram_bot;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter;
    private int lastRequestTime;

    public TelegramBot(int lastRequestTime) {
        REQUEST_LIMIT = 5;
        this.requestCounter = 0;
        this.lastRequestTime = lastRequestTime;
    }
    public void sendMessage(String message) {

        synchronized (this) {
            System.currentTimeMillis();

            System.out.println("отправка сообщения " );


        DateFormat.now();
    }
    }

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(0);

        ExecutorService executorService = Executors.newFixedThreadPool(15);
        executorService.execute(bot::sendMessage);
    }
}
