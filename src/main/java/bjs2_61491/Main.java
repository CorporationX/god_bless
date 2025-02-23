package bjs2_61491;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 7;
    private static final int MESSAGE_COUNT_BY_THREAD = 10;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        Thread[] senderThreads = new Thread[THREAD_COUNT];
        for (int i = 0; i < senderThreads.length; i++) {
            int senderNumber = i;
            senderThreads[i] = new Thread(() -> {
                senderThreadProc(senderNumber, bot);
            });

            senderThreads[i].start();
        }

        for (Thread senderThread : senderThreads) {
            try {
                senderThread.join();
            } catch (InterruptedException e) {
                log.error("Ожидание Потока отправителя прервано: {}", e.getMessage(), e);
            }
        }

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
