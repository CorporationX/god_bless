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

    public boolean releaseLoad(double load) {
        if (this.load >= load) {
            this.load -= load;
            return true;
        }
        return false;
    }

    public boolean handleLoad(double additionalLoad) {
        if ((this.load + additionalLoad) <= maxLoad) {
            this.allocateLoad(additionalLoad);
            return true;
        }
        return false;
    }
}