package school.faang.Telegram;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TelegramBot bot = new TelegramBot();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 30; i++) {
            final int messageNum = i;
            executor.execute(() ->
                bot.sendMessage("Сообщение " + messageNum));
        }
        executor.shutdown();
        if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
            log.warn("Не все задачи завершились в течение таймаута");
        }
        log.info("Все сообщения отправлены");
    }
}
