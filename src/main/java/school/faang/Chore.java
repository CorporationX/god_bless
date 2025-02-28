package school.faang;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private final String title;
    private final Random random = new Random();

    @Override
    public void run() {
        log.info("Началось выполнение задачи: {}\nПотоком: {}",
                title, Thread.currentThread().getName());
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            log.error("Задача {} была прервана", title);
            Thread.currentThread().interrupt();
        }
        log.info("Выполнение задачи: {} успешно завершилось!", title);
    }
}
