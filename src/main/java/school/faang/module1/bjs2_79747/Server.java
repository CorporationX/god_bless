package school.faang.module1.bjs2_79747;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private final double maxLoad;
    private double energyConsumption;
}