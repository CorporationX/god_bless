package school.faang.bjs2_91099;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {

    private static final int TOTAL_MESSAGE = 1000;
    private static final int START_INDEX = 0;
    private static final int THREAD_COUNT = 5;
    private static final int END_INDEX = TOTAL_MESSAGE / THREAD_COUNT;

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        SenderRunnable senderMessage = null;
        log.info("Запускаем обработчики писем");
        for (int i = 0; i < THREAD_COUNT; i++) {
            senderMessage = new SenderRunnable(START_INDEX, END_INDEX);
            Thread thread = new Thread(senderMessage);
            thread.start();
            threadList.add(thread);
        }
        try {
            log.info("Ждем обработки писем от обработчиков");
            for (Thread thread : threadList) {
                thread.join();
                log.info("{} - Обработчик {} - Обработано писем", thread.getName(), senderMessage.getStartIndex());
            }
            log.info("Отправка сообщений законченна! - отправленно {}", SenderRunnable.count);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }
}
