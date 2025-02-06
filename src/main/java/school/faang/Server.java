package school.faang;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Server {
    private double load;
    private final double maxLoad;
    private double energyConsumption;

    public Server(double load, double maxLoad, double energyConsumption) {
        validateEnergyConsumption(energyConsumption);
        validateLoad(load);
        validateMaxLoad(maxLoad);
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    private void validateEnergyConsumption(double energyConsumption) {
        if (energyConsumption < 0) {
            throw new IllegalArgumentException("Energy consumption can't be less than 0");
        }
    }

    private void validateLoad(double load) {
        if (load < 0) {
            throw new IllegalArgumentException("The load can't be less than 0");
        }
    }

    private void validateMaxLoad(double maxLoad) {
        if (maxLoad < 0) {
            throw new IllegalArgumentException("Max load can't be less than 0");
        }
    }
}
