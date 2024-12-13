package school.faang.task_45023;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
}
