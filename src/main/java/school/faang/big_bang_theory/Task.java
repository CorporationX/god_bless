package school.faang.big_bang_theory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;


    @Override
    public void run() {
        log.info("{} начал выполнять задачу : {} ", name, task);
        try {
            Thread.sleep(2000);
            log.info("{} выполнил задачу {}", name, task);
        } catch (InterruptedException e) {
            log.info("Выполнение задачи {} прервано", task);
            Thread.currentThread().interrupt();
        }
    }
}
