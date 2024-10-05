package school.faang.task1310;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Server {

    private double load;
    private double maxLoad;
    private double energyConsumption;
}
