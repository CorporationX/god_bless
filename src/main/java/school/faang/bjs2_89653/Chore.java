package school.faang.bjs2_89653;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        try {
            log.info("{} начинает выполнение задачи: {}", Thread.currentThread().getName(), chore);
            Thread.sleep(10000);
            log.info("{} завершил выполнение задачи: {}", Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            log.info("{} был прерван", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
