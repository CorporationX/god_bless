package school.faang.microsoft;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    private static final Logger logger = LoggerFactory.getLogger(SenderRunnable.class);
    // Часто используемые сообщения для логирования
    private static final String MESSAGE_SENT_TEMPLATE = "Сообщение {} отправлено!";
    private static final String THREAD_STARTED_MESSAGE = "Новый Поток {} начал работу";

    @Override
    public void run() {
        logger.info(THREAD_STARTED_MESSAGE, Thread.currentThread().getName());

        validateIndices(startIndex, endIndex);
        for (int i = startIndex; i < endIndex; i++) {
            logger.info(MESSAGE_SENT_TEMPLATE, i);
        }
    }

    private void validateIndices(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным.");
        } else if (endIndex < startIndex) {
            throw new IllegalArgumentException("Начальный индекс не может быть больше конечного.");
        }
    }
}