package school.faang.multithreading_parallelism_thread.bjs2_91292;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Getter
@Slf4j
public class PigThread extends Thread {
    private final String pigName;
    private final String material;

    public void buildThread(int delayThread) {
        log.info("{} начал строить дом из {}", getPigName(), getMaterial());
        try {
            Thread.sleep(delayThread);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("{} закончил строить дом из {}",  getPigName(), getMaterial());
    }
}
