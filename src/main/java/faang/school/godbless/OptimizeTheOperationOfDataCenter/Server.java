package faang.school.godbless.OptimizeTheOperationOfDataCenter;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double load, double maxLoad) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = (load * 100) / maxLoad;
    }
}
