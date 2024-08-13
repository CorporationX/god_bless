package faang.school.godbless.bjs2_19287;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Map;

import static faang.school.godbless.bjs2_19287.Constants.DEFAULT_ENERGY_CONSUMPTION;
import static faang.school.godbless.bjs2_19287.Constants.DEFAULT_MAX_LOAD;
import static faang.school.godbless.bjs2_19287.Constants.ENERGY_CONSUMPTION_COEFFICIENT;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Server {
    @EqualsAndHashCode.Include
    private Integer id;
    private double load;
    private double maxLoad;
    private double energyConsumption;
    private boolean active;
    private static Integer sequenceId = 0;

    public Server(boolean active) {
        this.id = getNextSequenceId();
        this.load = 0;
        this.maxLoad = DEFAULT_MAX_LOAD;
        if (active) {
            this.active = true;
            energyConsumption = DEFAULT_ENERGY_CONSUMPTION;
        } else {
            this.active = false;
            this.energyConsumption = 0;
        }
    }

    private Integer getNextSequenceId() {
        return ++sequenceId;
    }

    public void increaseLoad(double load) {
        this.load = this.load + load;
        recalculateEnergyConsumption();
    }

    public void decreaseLoad(double load) {
        var newLoad = this.load - load;
        if (newLoad < 0) {
            this.load = 0;
        } else {
            this.load = newLoad;
        }
        recalculateEnergyConsumption();
    }

    public int getUtilization() {
        return (int) ((100 / maxLoad) * load);
    }

    public int calculateUtilizationWithNewLoad(double newLoad) {
        return (int) ((100 / maxLoad) * newLoad);
    }

    public void recalculateEnergyConsumption() {
        var newValue = load;
        var utilization = getUtilization();
        for (Map.Entry<ImmutablePair<Integer, Integer>, Double> entry : ENERGY_CONSUMPTION_COEFFICIENT.entrySet()) {
            var interval = entry.getKey();
            if (isBetween(utilization, interval.getLeft(), interval.getRight())) {
                newValue = newValue * entry.getValue();
            }
        }
        energyConsumption = newValue + DEFAULT_ENERGY_CONSUMPTION;
    }

    public void turnOn() {
        active = true;
        energyConsumption = DEFAULT_ENERGY_CONSUMPTION;
    }

    public void turnOff() {
        active = false;
        load = 0;
        energyConsumption = 0;
    }

    private boolean isBetween(int utilization, int left, int right) {
        return utilization >= left && utilization <= right;
    }

    public boolean isNotActive() {
        return !active;
    }

    @Override
    public String toString() {
        return "id = " + id
                + "; load = " + load
                + "; maxLoad = " + maxLoad
                + "; energy = " + energyConsumption
                + "; utilization = " + getUtilization();
    }

    public String toStringForInactive() {
        return "id = " + id
                + "; maxLoad = " + maxLoad
                + "; utilization = " + getUtilization();
    }
}
