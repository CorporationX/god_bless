package faang.school.godbless.BJS2_19329;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Server {

    @Setter
    private double load;
    private final double maxLoad;
    private double energyComsumption;
    private final int ENERGY_COEFFICIENT = 20;

    public Server(double load, double maxLoad) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyComsumption =  maxLoad/ENERGY_COEFFICIENT;
    }
}
