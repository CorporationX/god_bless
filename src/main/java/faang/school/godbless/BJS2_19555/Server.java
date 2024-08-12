package faang.school.godbless.BJS2_19555;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public double getAvailableLoad() {
        return maxLoad - load;
    }

    public double increaseLoad(double requestLoad) {
        return load += requestLoad;
    }

    public double decreaseLoad(double requestLoad) {
        return load -= requestLoad;
    }

    public void changeEnergyConsumption(double currentLoad, double newLoad) {
        energyConsumption *= newLoad / currentLoad;
    }
}
