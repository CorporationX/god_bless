package school.faang.datacenter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private Double load;
    private Double maxLoad;
    private Double energyConsumption;
}