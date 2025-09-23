package school.faang.bjs2_89908;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private static final int SLEEPING_TIME = 5;
    private String name;
    private String task;

    @Override
    public void run() {
        log.info("Задача {} начала выполняться.", name);
        try {
            TimeUnit.SECONDS.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            log.info("Потоку не удалось уснуть во время выполнения задачи {}, бессонница...)", name);
        }
        log.info("Задача {} закончила выполняться.", name);
    }
}
