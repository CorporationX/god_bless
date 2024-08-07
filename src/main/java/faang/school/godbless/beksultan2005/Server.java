package faang.school.godbless.beksultan2005;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;

@Getter
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad) {
        this.load = 0.00;
        this.maxLoad = maxLoad;
        this.energyConsumption = 0.00;
    }

    public boolean canAllocate(double requestedLoad) {
        return (load + requestedLoad) <= maxLoad;
    }

    public boolean canReleaseLoad(double requestedLoad) {
        return load >= requestedLoad;
    }

    public void allocateLoad(double requestedLoad) {
        if (canAllocate(requestedLoad)) {
            load += requestedLoad;
            updateEnergyConsumption();
        }
    }

    public void releaseLoad(double releasedLoad) {
        if (canReleaseLoad(releasedLoad)){
            load -= releasedLoad;
            updateEnergyConsumption();
        }
    }

    private void updateEnergyConsumption(){
        energyConsumption = load / maxLoad;
    }
}
