package faang.school.godbless.datacentre;

public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server() {}

    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public void increaseLoad(double load) {
        this.load += load;
    }

    public void decreaseLoad(double load) {
        this.load -= load;
    }

    public double getLoad() {
        return load;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public double getEnergyConsumption () {
        return energyConsumption;
    }
}
