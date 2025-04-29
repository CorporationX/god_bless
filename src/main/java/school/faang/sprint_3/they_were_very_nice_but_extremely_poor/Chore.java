package school.faang.sprint_3.they_were_very_nice_but_extremely_poor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        log.info("Thread {} complete {}", Thread.currentThread().getName(), chore);
    }
}