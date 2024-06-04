package faang.school.godbless.datacenter.service;

import faang.school.godbless.datacenter.model.DataCenter;
import faang.school.godbless.datacenter.model.ResourceRequest;
import faang.school.godbless.datacenter.model.Server;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataCenterService {

    DataCenter dataCenter;

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void deleteServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        throw new UnsupportedOperationException();
    }

    public void allocateResources(ResourceRequest resourceRequest) {
        throw new UnsupportedOperationException();
    }

    public void releaseResources(ResourceRequest resourceRequest) {
        throw new UnsupportedOperationException();
    }
}
