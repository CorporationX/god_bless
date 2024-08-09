package faang.school.godbless.BJS2_19396;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private double energyConsumption;
    private double maxEnergyConsumption;

    public Server(double load, EnergyConsumptionService service) {
        this.load = load;
        this.energyConsumption = service.getEnergyConsumption(0);
        this.maxEnergyConsumption = service.getMaxEnergyConsumption(energyConsumption);
    }

    public void addLoad(double load) {
        this.load += load;
    }

    public void removeLoad(double load) {
        this.load -= load;
    }
}
