package data.center;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();
    private final Map<ResourceRequest, Server> requestsLoaded = new HashMap<>();

    public boolean allocateResources(ResourceRequest resourceRequest) {
        if (this.requestsLoaded.containsKey(resourceRequest)) {
            return false;
        }

        for (Server server: this.servers) {
            if (server.allocatedLoad(resourceRequest.getLoad())) {
                this.requestsLoaded.put(resourceRequest, server);
                return true;
            }
        }

        return false;
    }

    public boolean releaseResources(ResourceRequest resourceRequest) {
        Server allocatedServer = this.requestsLoaded.get(resourceRequest);
        if (allocatedServer == null) {
            return false;
        }

        allocatedServer.removeLoad(resourceRequest.getLoad());
        this.requestsLoaded.remove(resourceRequest);

        return true;
    }

    public double calculateCost() {
        double totalCost = 0;
        for (Server server: this.servers) {
            totalCost+= server.getCost();
        }

        return totalCost;
    }
}
