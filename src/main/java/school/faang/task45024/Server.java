package school.faang.task45024;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Server {

    private final double maxLoad;
    private double load;
    private double energyConsumption;

    public Server(double load, double maxLoad, double energyConsumption) {
        if (load > maxLoad) {
            throw new IllegalArgumentException("Load exceeds max load");
        }

        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }
}
