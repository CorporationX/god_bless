package school.faang.task_45019;

import lombok.*;

@AllArgsConstructor
@Data
public class Server {
    private double load;
    private final double maxLoad;
    private double energyConsumption;

}
