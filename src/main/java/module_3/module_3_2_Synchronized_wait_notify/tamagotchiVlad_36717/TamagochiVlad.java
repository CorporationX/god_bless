package module_3.module_3_2_Synchronized_wait_notify.tamagotchiVlad_36717;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@AllArgsConstructor
public class TamagochiVlad {
    private static final Logger LOG = LoggerFactory.getLogger(TamagochiVlad.class);
    private static final long TIME_FEED = 1000;
    private static final long TIME_PLAY = 3000;
    private static final long TIME_CLEAN = 1500;
    private static final long TIME_SLEEP = 2000;

    private final String name;

    public synchronized void feed() {
        LOG.info("{} кушает...", name);
        sleepThread(TIME_FEED);
        LOG.info("{} наелся!", name);
    }

    public synchronized void play() {
        LOG.info("{} играет...", name);
        sleepThread(TIME_PLAY);
        LOG.info("{} наигрался!", name);
    }

    public synchronized void clean() {
        LOG.info("{} чистим...", name);
        sleepThread(TIME_CLEAN);
        LOG.info("{} начистили!", name);
    }

    public synchronized void sleep() {
        LOG.info("{} спит...", name);
        sleepThread(TIME_SLEEP);
        LOG.info("{} поспал!", name);
    }

    private void sleepThread(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOG.warn("Thread is dead: {}", e.getMessage());
        }
    }
}
