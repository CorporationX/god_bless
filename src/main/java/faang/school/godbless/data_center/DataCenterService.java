package faang.school.godbless.data_center;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
public class DataCenterService {

    public void addServer(DataCenter dataCenter, Server server) {
        if (server != null) {
            dataCenter.getServers().add(server);
        } else {
            log.warn("Cannot add non-existing server");
        }
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        if (!server.getRequestMap().isEmpty()) {
            throw new RuntimeException("This server is providing some Service to Clients");
        }
        if (dataCenter.getServers().contains(server)) {
            dataCenter.getServers().remove(server);
        } else {
            log.warn("Could not find and remove server {}", server);
        }
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public void allocateResources(DataCenter dataCenter, ResourceRequest request) {
        if (dataCenter.getResourceRequests().contains(request.getId())) {
            releaseResources(dataCenter, request);
            allocateResources(dataCenter, request);
        } else {
            Server serverToAddRequest = null;
            for (Server server : dataCenter.getServers()) {
                if (server.getMaxLoad() - server.getLoad() >= request.getLoad()) {
                    serverToAddRequest = server;
                    break;
                }
            }
            if (serverToAddRequest == null) {
                log.warn("No server is available");
            } else {
                dataCenter.getServers().remove(serverToAddRequest);
                serverToAddRequest.addRequest(request);
                dataCenter.getResourceRequests().add(request.getId());
                dataCenter.getServers().add(serverToAddRequest);
            }
        }
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        Server serverToReleaseRequest = null;
        for (Server server : dataCenter.getServers()) {
            if (server.getRequestMap().containsKey(request.getId())) {
                serverToReleaseRequest = server;
                break;
            }
        }
        if (serverToReleaseRequest != null) {
            dataCenter.getServers().remove(serverToReleaseRequest);
            serverToReleaseRequest.removeRequest(request);
            dataCenter.getResourceRequests().remove(request.getId());
            dataCenter.getServers().add(serverToReleaseRequest);
        } else {
            log.warn("Could not find and release resources of request {}", request);
        }
    }

    public void optimizationByStrategy(DataCenter dataCenter) {
        Set<ResourceRequest> resourceRequests = new HashSet<>();
        Set<Server> serverSet = new HashSet<>();

        for (Server server : dataCenter.getServers()) {
            for (Map.Entry<Integer, ResourceRequest> resourceRequest : server.getRequestMap().entrySet()) {
                resourceRequests.add(resourceRequest.getValue());
            }
            serverSet.add(server);
            server.setLoad(0);
            server.getRequestMap().clear();
        }

        dataCenter.setServers(new TreeSet<>(dataCenter.getOptimizationStrategy().getCompareStrategy()));
        dataCenter.getResourceRequests().clear();

        for (Server server : serverSet) {
            addServer(dataCenter, server);
        }
        for (ResourceRequest resourceRequest : resourceRequests) {
            allocateResources(dataCenter, resourceRequest);
        }
    }

    public void changeOptimizationStrategy(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        dataCenter.setOptimizationStrategy(optimizationStrategy);
        optimizationByStrategy(dataCenter);
    }

    public void optimize(DataCenter dataCenter) {
        while (true) {
            optimizationByStrategy(dataCenter);
            try {
                Thread.sleep(1800);
            } catch (InterruptedException exception) {
                System.out.println("Could not optimize DataCenter in this 30 minutes");
            }
        }
    }
}
