package faang.school.godbless.data.center;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad) {
        this.load = 0;
        this.maxLoad = maxLoad;
        this.energyConsumption = 0;
    }
}
