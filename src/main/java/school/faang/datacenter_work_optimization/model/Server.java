package school.faang.datacenter_work_optimization.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public double getEfficiency() {
        return energyConsumption / maxLoad;
    }
}
