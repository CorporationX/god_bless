package school.faang.data_center;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private final double MAX_LOAD;
    private double energyConsumption;
}
