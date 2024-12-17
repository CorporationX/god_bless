package school.faang.task_48307;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            log.info("{} начинает выполнение задачи {}",
                    Thread.currentThread().getName(), chore);
            Thread.sleep(2000);
            log.info("{} завершил работу успешно", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            log.error("{} прервался из-за ошибки: {}",
                    Thread.currentThread().getName(), e.getMessage());
        }
    }
}
