package optimize_data_center_work;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad) {
        this.maxLoad = maxLoad;
    }
}
