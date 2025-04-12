package school.faang.data_center;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private final double maxLoad;
    private double energyConsumption;
}
