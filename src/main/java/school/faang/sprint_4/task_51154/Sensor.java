package school.faang.sprint_4.task_51154;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Slf4j
@ToString
public class Sensor implements Runnable {
    private static final int SLEEP_TIME = 1000;
    private static final int MAX_SENSOR_DATA = 1000;

    private final int id;
    private final Substation substation;
    @ToString.Exclude
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public void run() {
        startGeneratingData();
    }

    public void startGeneratingData() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(SLEEP_TIME);
                substation.receiveData(id, random.nextDouble(MAX_SENSOR_DATA));
            } catch (InterruptedException e) {
                log.info("Thread interrupted.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
