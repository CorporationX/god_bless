package school.faang.sprint_1.task_45025.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Server {
    @Setter
    private double load;
    private double maxLoad;
    @Setter
    private double energyConsumption;
}
