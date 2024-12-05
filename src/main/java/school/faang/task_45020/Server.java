package school.faang.task_45020;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Getter
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
}
