package school.faang.datacenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private final double maxLoad;

    private double load;
    private double energyConsumption;
}