package faang.school.godbless;

import lombok.Getter;

@Getter
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad, double energyConsumption) {
        this.load = 0;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public void addLoad(double additionalLoad) {
        if (load + additionalLoad <= maxLoad) {
            load += additionalLoad;
        } else {
            throw new IllegalArgumentException("Load exceeds maxLoad");
        }
    }

    public void removeLoad(double loadToRemove) {
        if (load - loadToRemove >= 0) {
            load -= loadToRemove;
        } else {
            throw new IllegalArgumentException("Cannot remove more load than is currently allocated");
        }
    }

    public boolean canHandleLoad(double additionalLoad) {
        return load + additionalLoad <= maxLoad;
    }
}

