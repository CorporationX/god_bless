package faang.school.godbless.OptimizeDataCenter2064;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }
}