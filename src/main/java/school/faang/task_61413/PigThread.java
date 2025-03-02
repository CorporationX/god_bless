package school.faang.task_61413;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class PigThread extends Thread {
    private final String pigName;
    private final String material;

    public void buildHouse(int delay) {
        log.info("{} started building his house out of {}.", this.getPigName(), this.getMaterial());
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("{} built his house.", this.getPigName());
    }
}
