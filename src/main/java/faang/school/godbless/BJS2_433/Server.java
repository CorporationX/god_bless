package faang.school.godbless.BJS2_433;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server (double maxLoad) {
        this.maxLoad = maxLoad;
    }
}
