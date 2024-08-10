package faang.school.godbless.BJS2_19800.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad, double energyConsumption) {
        this.load = 0;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }
}
