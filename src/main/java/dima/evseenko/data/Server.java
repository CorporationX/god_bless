package dima.evseenko.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
}
