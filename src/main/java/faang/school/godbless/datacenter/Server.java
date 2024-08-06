package faang.school.godbless.datacenter;

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

    public void allocateLoad(double load) {
        this.load += load;
    }

    public void releaseLoad(double load) {
        this.load -= load;
    }

    public boolean canHandleLoad(double additionalLoad) {
        return (this.load + additionalLoad) <= maxLoad;
    }
}