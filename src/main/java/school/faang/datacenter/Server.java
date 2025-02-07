package school.faang.datacenter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
}
