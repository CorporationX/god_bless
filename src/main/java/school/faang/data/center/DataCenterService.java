package school.faang.data.center;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class DataCenterService {

    private final OptimizationStrategy optimizationStrategy;

    public void add(@NonNull Server server, DataCenter dataCenter) {
        dataCenter.add(server);
        optimizationStrategy.optimize(dataCenter);
    }

    public void remove(@NonNull Server server, DataCenter dataCenter) {
        dataCenter.remove(server);
        optimizationStrategy.optimize(dataCenter);
    }

    public void allocateResources(@NonNull ResourceRequest request, DataCenter dataCenter) {
        dataCenter.allocateResources(request);
        optimizationStrategy.optimize(dataCenter);
    }

    public void releaseResources(@NonNull ResourceRequest request, DataCenter dataCenter) {
        dataCenter.releaseResources(request);
        optimizationStrategy.optimize(dataCenter);
    }
}
