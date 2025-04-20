package school.faang.household;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            log.info("{} начал выполнять: {}", Thread.currentThread().getName(), chore);
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1500));
            log.info("{} завершил: {}", Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            log.error("{} был прерван во время: {}", Thread.currentThread().getName(), chore);
            Thread.currentThread().interrupt();
        }
    }
}
