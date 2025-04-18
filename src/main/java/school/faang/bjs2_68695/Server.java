package school.faang.bjs2_68695;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load = 0.0;
    private final double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad, double energyConsumption) {
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }
}
