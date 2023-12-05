package faang.school.godbless.ElectricalSubstations;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;
@Data
public class Sensor {
    private int id;
    private Substation substation;

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
    }

    public void startGeneratingData() {
            substation.receiveData(substation.getId(), ThreadLocalRandom.current().nextDouble(1.0 , 10.0));
            System.out.println(Thread.currentThread().getId() + " | Generated data for substation " + substation.getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
