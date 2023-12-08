package DataCenter;

public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption; //текущие энергозатраты

    public Server(double load, double maxLoad) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = load * 100;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
