package bjs2_61491;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 7;
    private static final int MESSAGE_COUNT_BY_THREAD = 10;
    private static final int WAITING_TERMINATION_TIMEOUT_SECONDS = 6;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        for (int i = 0; i < THREAD_COUNT; i++) {
            var senderNumber = i;
            executor.submit(() -> senderThreadProc(senderNumber, bot));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(WAITING_TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.error("Операция не завершилась за {} секунд", WAITING_TERMINATION_TIMEOUT_SECONDS);
            }
        } catch (InterruptedException e) {
            log.error("Ошибка ожидания завершения потоков: {}", e.getMessage(), e);
        }

        executor.shutdownNow();

        log.info("Все сообщения отправлены");
    }

    private static void senderThreadProc(int senderNumber, TelegramBot bot) {
        log.info("Отправитель #{} начал работу", senderNumber + 1);

        for (int messageNumber = 0; messageNumber < MESSAGE_COUNT_BY_THREAD; messageNumber++) {
            try {
                bot.sendMessage(
                        String.format("Сообщение #%d из отправителя %d", messageNumber + 1, senderNumber + 1));
            } catch (InterruptedException e) {
                log.error("Поток отправителя #{} прерван: {}", senderNumber + 1, e.getMessage(), e);
                return;
            }
        }
    }
}
