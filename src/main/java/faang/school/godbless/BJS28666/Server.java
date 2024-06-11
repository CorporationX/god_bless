package faang.school.godbless.BJS28666;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public boolean tryAllocateResources(ResourceRequest request) {
        if (load + request.getLoad() <= maxLoad) {
            load += request.getLoad();
            return true;
        }
        return false;
    }
}
