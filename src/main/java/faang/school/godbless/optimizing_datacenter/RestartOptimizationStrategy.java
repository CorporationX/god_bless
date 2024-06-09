package faang.school.godbless.optimizing_datacenter;

import java.util.Map;

public class RestartOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        for (Map.Entry<ResourceRequest, Server> entry : dataCenter.getRequestMap().entrySet()) {
            entry.getValue().releaseRequest(entry.getKey());
        }
        dataCenter.getRequestMap().clear();
    }
}