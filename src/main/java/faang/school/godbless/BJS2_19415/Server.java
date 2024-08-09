package faang.school.godbless.BJS2_19415;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Server {
    private static final double MAX_POSSIBLE_LOAD = 100.0;
    private static final double MIN_POSSIBLE_LOAD = 0.0;
    private static int serverIndex = 0;
    @ToString.Include
    @EqualsAndHashCode.Include
    private int id; //для генерации уникального hash
    @EqualsAndHashCode.Include
    @Getter
    private final double maxLoad;
    @Getter
    @ToString.Include
    private double load;
    @Getter
    @ToString.Include
    private double energyConsumption;
    private double maxEnergyConsumption;

    public Server(double maxEnergyConsumption) {
        this.id = ++serverIndex;
        this.maxLoad = MAX_POSSIBLE_LOAD;
        this.maxEnergyConsumption = maxEnergyConsumption;
        this.energyConsumption = load * maxEnergyConsumption / MAX_POSSIBLE_LOAD;
    }

    public void setLoad(double load) {
        this.load = load;
        this.energyConsumption = load * maxEnergyConsumption / MAX_POSSIBLE_LOAD;
    }

    public void setLoadToMaxValue() {
        setLoad(MAX_POSSIBLE_LOAD);
    }

    public void setLoadToMinValue() {
        setLoad(MIN_POSSIBLE_LOAD);
    }
}

