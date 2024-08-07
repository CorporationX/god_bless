package faang.school.godbless.BJS2_19329;

import lombok.Getter;

@Getter
public class Server {

    private double load = 0;
    private final double maxLoad;

    private final int ENERGY_COEFFICIENT = 2;
    private double energyConsumption = load * ENERGY_COEFFICIENT;

    public Server(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public void setLoad(double load) {
        this.load = load;
        energyConsumption = load * ENERGY_COEFFICIENT;
    }
}
