package faang.school.godbless.BJS2_19559;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Server {
    @Setter
    private double load;
    private final double maxLoad;
    private final double energyConsumption;

    public Server(double maxLoad, double energyConsumption) {
        this.load = 0.0;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public boolean canAllocate(double requestedLoad) {
        return (load + requestedLoad) <= maxLoad;
    }

    public void allocate(double requestedLoad) {
        if (canAllocate(requestedLoad)) {
            load += requestedLoad;
        } else {
            throw new IllegalArgumentException("Cannot allocate requested load.");
        }
    }

    public void release(double requestedLoad) {
        if (requestedLoad <= load) {
            load -= requestedLoad;
        } else {
            throw new IllegalArgumentException("Cannot release more load than currently allocated.");
        }
    }
}