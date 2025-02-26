package school.faang.task_60599;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int i = startIndex; i < endIndex; i++) {
            log.info("Поток: {}, Письмо: {}, Статус: Отправлено", threadName, i);
        }
    }
}
