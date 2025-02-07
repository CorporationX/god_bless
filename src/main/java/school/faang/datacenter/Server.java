package school.faang.datacenter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public void setEnergyConsumption(double load, double maxLoad) {
        this.energyConsumption = (load / maxLoad) * 100;
    }

}
