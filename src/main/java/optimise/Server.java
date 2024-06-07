package optimise;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public boolean takeLoad(double newLoad) {
        if (maxLoad - load >= newLoad) {
            load += newLoad;
            return true;
        }
        return false;
    }

    public boolean releaseLoad(double loadToBeReleased) {
        if (load >= loadToBeReleased) {
            load -= loadToBeReleased;
            return true;
        }
        return false;
    }
}
