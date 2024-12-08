package school.faang.task_45026.entity;

import lombok.Getter;

@Getter
public class Server {
    private double load;
    private final double maxLoad;
    //    в условиях не написано как именно задавать значение данного поля, поэтому решил оставить пустым
    private double energyConsumption;

    public Server(double maxLoad) {
        validateLoad(maxLoad);
        this.maxLoad = maxLoad;
    }

    public void setLoad(double load) {
        validateLoad(load);
        this.load = load;
    }

    public void setEnergyConsumption(double energyConsumption) {
        if (energyConsumption < 0) {
            throw new IllegalArgumentException("energyConsumption cannot be negative");
        }
        this.energyConsumption = energyConsumption;
    }

    public double addLoad(double inputLoad) {
        validateLoad(inputLoad);
        double availableLoad = maxLoad - load;

        double loadToAdd = Math.min(inputLoad, availableLoad);
        load += loadToAdd;
        inputLoad -= loadToAdd;
        return inputLoad;
    }

    public double releaseLoad(double inputLoad) {
        validateLoad(inputLoad);
        double availableLoad = load;

        double loadToRelease = Math.min(inputLoad, availableLoad);
        load -= loadToRelease;
        inputLoad -= loadToRelease;
        return inputLoad;
    }

    public void validateLoad(double load) {
        if (load < 0) {
            throw new IllegalArgumentException("loadToAdd must not be negative");
        }
    }
}
