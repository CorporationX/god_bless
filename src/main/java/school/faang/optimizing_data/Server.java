package school.faang.optimizing_data;

import lombok.Getter;

@Getter
public class Server {
    private final double maxLoad;
    private final double energyConsumption;
    private double load;

    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = validateLoad(load);
        this.maxLoad = validateMaxLoad(maxLoad);
        this.energyConsumption = validateEnergyConsumption(energyConsumption);
    }

    private double validateLoad(double load) {
        if (load < 0) {
            throw new IllegalArgumentException("Load must be between 0 and maxLoad ("
                    + maxLoad + "). Provided load: " + load);
        }
        return load;
    }

    private double validateMaxLoad(double maxLoad) {
        if (maxLoad < 0) {
            throw new IllegalArgumentException("maxLoad must be greater than 0! Provided maxLoad: " + maxLoad);
        }
        return maxLoad;
    }

    private double validateEnergyConsumption(double energyConsumption) {
        if (energyConsumption < 0) {
            throw new IllegalArgumentException("Energy consumption cannot be negative! Provided energyConsumption: "
                    + energyConsumption);
        }
        return energyConsumption;
    }

    public void setLoad(double load) {
        if (load < 0 || load > maxLoad) {
            throw new IllegalArgumentException("Load must be between 0 and maxLoad ("
                    + maxLoad + "). Provided load: " + load);
        }
        this.load = load;
    }

}