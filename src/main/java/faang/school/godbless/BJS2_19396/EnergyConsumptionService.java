package faang.school.godbless.BJS2_19396;

import java.util.Random;

public class EnergyConsumptionService {
    private Random random;

    public EnergyConsumptionService(Random random) {
        this.random = random;
    }

    public double getEnergyConsumption(double load) {
        return random.nextDouble(load, 1000);
    }

    public double getMaxEnergyConsumption(double energyConsumption) {
        return random.nextDouble(energyConsumption, 1000);
    }
}
