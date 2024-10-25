package school.faang.electricalsubstations;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class Sensor {
    private static final int MIN_VALUE_SENSOR = 200;
    private static final int MAX_VALUE_SENSOR = 240;

    private int id;
    private Substation substation;

    public void startGeneratingData() {
        substation.receiveData(id, ThreadLocalRandom.current().nextDouble(MIN_VALUE_SENSOR, MAX_VALUE_SENSOR));
    }
}
