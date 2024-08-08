package faang.school.godbless.DataCenter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Server {

    private final static double LOAD_TO_ENERGY_COF = 0.5;

    @EqualsAndHashCode.Exclude
    private final double maxLoad;

    @EqualsAndHashCode.Include
    private final int id;

    @EqualsAndHashCode.Exclude
    private double load;

    @EqualsAndHashCode.Exclude
    private double energyConsumption;

    public void setLoad(double load) {
        this.load = load;
        energyConsumption = load * LOAD_TO_ENERGY_COF;
    }
}
