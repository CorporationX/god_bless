package school.faang.optimization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Server {
    private double load;
    private final double maxLoad;
    private double energyConsumption;
}