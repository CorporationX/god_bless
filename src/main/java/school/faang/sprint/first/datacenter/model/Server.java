package school.faang.sprint.first.datacenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private int id;
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public void updateEnergyConsumption(double load, double maxLoad) {
        this.setEnergyConsumption(load / maxLoad * 1000);
    }
}
