package dataCenter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Server {
    private int id;
    private double load;
    private double maxLoad;
    private double energyConsumption;


}
