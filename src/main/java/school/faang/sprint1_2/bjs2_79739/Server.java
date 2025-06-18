package school.faang.sprint1_2.bjs2_79739;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"load", "maxLoad", "energyConsumption"})
public class Server {
    private Integer id;
    private double load = 0;
    private double maxLoad = 100;
    private double energyConsumption;

    public Server(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
