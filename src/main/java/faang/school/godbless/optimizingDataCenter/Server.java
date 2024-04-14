package faang.school.godbless.optimizingDataCenter;

import lombok.Data;

@Data
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double load, double maxLoad) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = load;
    }

    public void setLoad(double load) {
        this.load = load;
        this.energyConsumption = load;

    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
        this.load = energyConsumption;
    }

    @Override
    public String toString() {
        return "\nServer{" +
                "load=" + load +
                ", maxLoad=" + maxLoad +
                ", energyConsumption=" + energyConsumption +
                '}';
    }
}
