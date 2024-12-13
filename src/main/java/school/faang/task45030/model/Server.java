package school.faang.task45030.model;

import lombok.*;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private final double maxLoad;
    private double energyConsumption;
}
