package school.faang.task_45018;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
}