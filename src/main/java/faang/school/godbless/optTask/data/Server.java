package faang.school.godbless.optTask.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
}
