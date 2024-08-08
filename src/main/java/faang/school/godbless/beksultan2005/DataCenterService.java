package faang.school.godbless.beksultan2005;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class DataCenterService implements OptimizationStrategy {
    private DataCenter dataCenter;

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.00;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public void getAllEnergyConsumption() {
        int i = 1;
        for (Server server : dataCenter.getServers()) {
            System.out.println("Energy consumption " + i++ + " server - " + (int) (server.getEnergyConsumption() * 100) + "%");
        }
    }

    public boolean allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.canAllocate(request.getLoad())) {
                dataCenter.getResourceRequests().put(request, server);
                server.allocateLoad(request.getLoad());
                return true;
            }
        }
        return false;
    }

    public void releaseResources(ResourceRequest request) {
        Server server = dataCenter.getResourceRequests().get(request);
        server.releaseLoad(request.getLoad());
        dataCenter.getResourceRequests().remove(request);
    }

    public void optimize(DataCenter dataCenter) {
        List<ResourceRequest> resourceRequests = new ArrayList<>(dataCenter.getResourceRequests().keySet().stream().toList());
        resourceRequests.sort(Comparator.comparingDouble(ResourceRequest::getLoad).reversed());
        LinkedList<Server> servers = new LinkedList<>();

        dataCenter.getServers().sort(Comparator.comparingDouble(Server::getMaxLoad).reversed());

        for (Server server : dataCenter.getServers()) {
            server.setLoad(0.00);
            server.updateEnergyConsumption();
            servers.addLast(server);
        }

        dataCenter.getResourceRequests().clear();


        for (ResourceRequest resourceRequest : resourceRequests) {
            for (Server server : dataCenter.getServers()) {
                if (dataCenter.getResourceRequests().containsKey(resourceRequest)) {
                    break;
                }
                if ((servers.getFirst() == server)) {
                    server.allocateLoad(resourceRequest.getLoad());
                    dataCenter.getResourceRequests().put(resourceRequest, server);
                    servers.removeFirst();
                    servers.addLast(server);
                }
            }
        }
    }
}
