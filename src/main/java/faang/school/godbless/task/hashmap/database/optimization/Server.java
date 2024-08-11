package faang.school.godbless.task.hashmap.database.optimization;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Server {
    private static final double ONE_ENERGY_POINT_IN_LOAD = 2; // ENERGY == LOAD x 2
    private static final double DEFAULT_ENERGY_CONSUMPTION = 50;
    private static final double MAX_LOAD = 100;

    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server() {
        this.load = 0.0;
        this.maxLoad = MAX_LOAD;
        this.energyConsumption = DEFAULT_ENERGY_CONSUMPTION;
    }

    public boolean allocateLoad(double load) {
        if (load > (maxLoad - this.load)) {
            return false;
        }
        this.load += load;
        energyConsumption += (load / ONE_ENERGY_POINT_IN_LOAD);
        return true;
    }

    public boolean releaseLoad(double load) {
        if (load > this.load) {
            return false;
        }
        this.load -= load;
        energyConsumption -= (load / ONE_ENERGY_POINT_IN_LOAD);
        return true;
    }
}
