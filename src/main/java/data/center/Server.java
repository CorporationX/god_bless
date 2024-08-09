package data.center;

import lombok.Getter;

@Getter
public class Server {
    private double load = 0;
    private final double maxLoad;
    private final double energyConsumption;
    private final double wattPerLoad;
    private final double costPerLoad;
    private final double costPerWatt = 2;

    public Server(double maxLoad, double energyConsumption, double wattPerLoad, double costPerLoad) {
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
        this.wattPerLoad = wattPerLoad;
        this.costPerLoad = costPerLoad;
    }

    public boolean allocatedLoad(double load) {
        double allocatedLoad = this.getLoad() + load;

        if (allocatedLoad > this.maxLoad || this.energyConsumption < this.calculateEnergyByLoad(allocatedLoad)) {
            return false;
        }

        this.load = allocatedLoad;
        return true;
    }

    public double loadPercent() {
        return this.getLoad() / this.getMaxLoad() * 100;
    }

    public void removeLoad(double load) {
        this.load -= load;
    }

    public double getCurrentEnergyConsumption() {
        return this.getLoad() * this.getWattPerLoad();
    }

    public double getCost() {
        return this.getLoad() * this.getCostPerLoad() + this.getCurrentEnergyConsumption() * this.getCostPerWatt();
    }

    private double calculateEnergyByLoad(double load) {
        return load * this.getWattPerLoad();
    }
}
