package faang.school.godbless.optimization;

public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public void setLoad(double load) {
        this.load = load;
    }

    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public double getLoad() {
        return load;
    }

    public double getMaxLoad() {
        return maxLoad;
    }
    public double getAvailableCapacity(){
        return getMaxLoad() - getLoad();
    }
}
