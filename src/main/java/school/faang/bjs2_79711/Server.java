package school.faang.bjs2_79711;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private final double maxLoad;
    private double energyConsumption;
}
