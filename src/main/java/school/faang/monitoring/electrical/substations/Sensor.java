package school.faang.monitoring.electrical.substations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
@Slf4j
public class Sensor {
    private final int id;
    private final Substation substation;

    public void startGeneratingData() {
        try {
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        System.out.println("Сенсор " + id + " отправляет данные на станцию " + substation);
        substation.receiveData(id, ThreadLocalRandom.current().nextDouble(1, 100));
    }
}
