package school.faang.microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record SenderRunnable(int startIndex, int endIndex) implements Runnable {
    @Override
    public void run() {
        validateIndex(startIndex, endIndex);
        for (int i = startIndex; i < endIndex; i++) {
            log.debug("Письмо {} отправлено потоком {} ", i, Thread.currentThread().getName());
        }
    }

    private void validateIndex(int startIndex, int endIndex) {
        if (startIndex > endIndex || startIndex < 0) {
            throw new IllegalArgumentException("Переданы неверные индексы, " +
                    "индексы больше нуля и начальный индекс больше конечного");
        }
    }
}