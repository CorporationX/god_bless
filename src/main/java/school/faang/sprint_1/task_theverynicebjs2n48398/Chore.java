package school.faang.sprint_1.task_theverynicebjs2n48398;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    @NonNull
    private String chore;

    @Override
    public void run() {
        try {
            log.info("{} выполняет задачу \"{}\"", Thread.currentThread().getName(), chore);
            TimeUnit.SECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
