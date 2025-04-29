package school.faang.multithreading.parallelism.bjs2_73033.weasley_chores;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        try {
            log.info("Thread = {} implements chore = {}", Thread.currentThread().getName(), chore);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("Thread = {} is interrupted, exception = {}", Thread.currentThread().getName(), e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
