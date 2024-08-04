package faang.school.godbless.DataCenter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Server {
    private final double MAX_LOAD;

    private final static double ENERGY_COF = 0.5; // 1 единица нагрузки = 0.5 энергопотребления
    private double load;
    private double energyConsumption;

    public void setLoad(double load) {
        this.load = load;
        energyConsumption = load * ENERGY_COF;
    }
}
