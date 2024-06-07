package faang.school.godbless.OptimizeTheOperationOfDataCenter;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double load) {
        this.load = load;
        this.maxLoad = 100;
        this.energyConsumption = (load * 100) / maxLoad;
    }
}
