package faang.school.godbless.BJS2_19329;

import lombok.Getter;

@Getter
public class Server {

    private final double SMALL_SERVER = 100;
    private final double MEDIUM_SERVER = 150;
    private final double LARGE_SERVER = 200;
    private final int ENERGY_COEFFICIENT = 50;
    private double load = 0;
    private double percentLoad;
    private final double maxLoad;
    private double energyEfficiency;
    private double energyConsumption;

    public Server(double maxLoad) {
        this.maxLoad = maxLoad;
        this.percentLoad = load * 100 / maxLoad;
    }

    public void setLoad(double load) {
        this.load = load;
        energyEfficiency = getEnergyEffinecyCoefficient(maxLoad);
        energyConsumption = ENERGY_COEFFICIENT * energyEfficiency * load;
        percentLoad = Math.floor((load * 100 / maxLoad) * 100) / 100;
    }

    private double getEnergyEffinecyCoefficient(Double maxLoad) {
        if (maxLoad == SMALL_SERVER) {
            return 0.2;
        } else if (maxLoad == MEDIUM_SERVER) {
            return 0.15;
        }
        return 0.12;
    }
}
