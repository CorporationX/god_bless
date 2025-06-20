package school.faang.bjs2_81650;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        log.info("{} начал выполнять задачу", name);
        try {
            Thread.sleep(5000);
        }  catch (InterruptedException e) {
            log.error("поток был прерван");
            Thread.currentThread().interrupt();
            throw  new RuntimeException(e);
        }
        log.info("{} закончил выполнять {}", name, task);
    }
}
