package faang.school.godbless.datacenter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Server {

    private double load;
    private double maxLoad;
    private double energyConsumption;
}
