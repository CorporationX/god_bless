package school.faang.nicebutpoor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private static final int SLEEP_TIME = 1000;
    private String chore;

    @Override
    public void run() {
        try {
            log.info("{} выполняет задачу: {}", Thread.currentThread().getName(), chore);
            Thread.sleep(SLEEP_TIME);
            System.out.println(chore + " выполнена!");
        } catch (InterruptedException e) {
            log.error("Задача '{}' была прервана!", chore, e);
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Задача '" + chore + "' прервана", e);
        }
    }
}
