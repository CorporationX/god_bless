package school.faang.bjs247660;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pig2Thread extends PigThread {

    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            log.info("Pig2 whose name is {} builds a house out of {}", getPigName(), getMaterial());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("The thread was interrupted while waiting for the thread to complete {}",
                    e.getMessage());
        }
    }
}