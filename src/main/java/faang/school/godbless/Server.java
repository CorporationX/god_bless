package faang.school.godbless;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad, double energyConsumption) {
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
        this.load = 0.0;
    }

    public void allocateLoad(double load) {
        if (this.canHandleLoad(load)) {
            this.load += load;
        }
    }

    public void releaseLoad(double load) {
        if (this.canReleaseLoad(load)) {
            this.load -= load;
        }
    }

    public boolean canHandleLoad(double load) {
        return this.load + load <= maxLoad;
    }

    public boolean canReleaseLoad(double load) {
        return this.load >= load;
    }
}
