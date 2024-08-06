package faang.school.godbless.beksultan2005;

public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = 0.00;
        this.maxLoad = maxLoad;
        this.energyConsumption = 0.00;
    }

    public boolean canAllocate(double requestedLoad) {
        return (load + requestedLoad) <= maxLoad;
    }

    public boolean canReleaseLoad(double requestedLoad) {
        return load > requestedLoad;
    }

    public void allocateLoad(double requestedLoad) {
        if (canAllocate(requestedLoad)) {
            load += requestedLoad;
            updateEnergyConsumption();
        }
    }

    public double releaseLoad(double releasedLoad) {
        if (canReleaseLoad(releasedLoad)){
            load -= releasedLoad;
            updateEnergyConsumption();
            return 0;
        }else {
            load = 0;
            updateEnergyConsumption();
            return (releasedLoad - load);
        }
    }

    private void updateEnergyConsumption(){
        energyConsumption = load / maxLoad;
    }
}
