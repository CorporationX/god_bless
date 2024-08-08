package faang.school.godbless.javahashmap.datacenter;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Server {

    public static final float MAX_LOAD = 100f;
    private static final float ENERGY_CONSUMPTION = 30f;

    @Getter
    private double load;
    private final double maxLoad;
    @Getter
    private double energyConsumption;

    public Server() {
        this.load = 0;
        this.maxLoad = MAX_LOAD;
        this.energyConsumption = 0;
    }

    public boolean canHandleLoad(double additionalLoad) {
        return (load + additionalLoad) <= maxLoad;
    }

    public void setLoad(double newValue) {
        if (newValue <= 0) {
            load = 0;
            energyConsumption = 0;
        } else {
            load = newValue;
            if (energyConsumption == 0) {
                energyConsumption = ENERGY_CONSUMPTION;
            }
        }
    }
}
