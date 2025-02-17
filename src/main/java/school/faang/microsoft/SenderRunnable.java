package school.faang.microsoft;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    private static final Logger logger = LoggerFactory.getLogger(SenderRunnable.class);

    @Override
    public void run() {
        logger.info("Новый Поток {} начал работу", Thread.currentThread().getName());

        validateIndices(startIndex, endIndex);
        for (int i = startIndex; i < endIndex; i++) {
            logger.info("Сообщение {} отправлено!", i);
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