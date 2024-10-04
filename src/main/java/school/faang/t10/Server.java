package school.faang.t10;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
    private double idlePowerConsumption = 100;
    private double maxPowerConsumption = 300;

    public Server(double maxLoad) {
        this.maxLoad = maxLoad;
        this.load = 0;
        this.energyConsumption = calculateEnergyConsumption();
    }

    private double calculateEnergyConsumption() {
        double loadPercentage = load / maxLoad;
        return idlePowerConsumption + (maxPowerConsumption - idlePowerConsumption) * loadPercentage;
    }

    public void setLoad(double load) {
        this.load = Math.min(load, maxLoad);
        calculateEnergyConsumption();
    }
}
