package school.faang.bjs245028.service;

import school.faang.bjs245028.model.ResourceRequest;
import school.faang.bjs245028.model.Server;

public interface DataCenterProvider {
    void addServer(Server server);

    void removeServer(Server server);

    double getTotalEnergyConsumption();

    void allocateResources(ResourceRequest request);

    void releaseResources(ResourceRequest request);
}
