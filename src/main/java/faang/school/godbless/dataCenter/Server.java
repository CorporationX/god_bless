package faang.school.godbless.dataCenter;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Server {

    private Double load;
    private Double maxLoad;
    private Double energyConsumption;
}
