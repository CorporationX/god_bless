package faang.school.godbless.BJS2_4135.models;

import lombok.Data;

@Data
public class Server {
    private double maxLoad;
    private double energyConsumption;
    private double load = 0.0;

    public Server(double maxLoad, double energyConsumption) {
        setMaxLoad(maxLoad);
        setEnergyConsumption(energyConsumption);
    }

    public void allocate(double additionalLoad) {
        if (getLoad() + additionalLoad > getMaxLoad()) {
            throw new IllegalArgumentException("Невозможно выделить нагрузку, превышающую максимальную пропускную способность");
        }

        setLoad(getLoad() + additionalLoad);
    }

    public void release(double loadToRelease) {
        setLoad(getLoad() - loadToRelease <= 0 ? 0 : getLoad() - loadToRelease);
    }
}
