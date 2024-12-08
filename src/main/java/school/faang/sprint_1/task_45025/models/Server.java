package school.faang.sprint_1.task_45025.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Server {
    private double load;
    private final double maxLoad;
    private double energyConsumption;
}
