package faang.school.godbless.BJS28666;

import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class DataCenterService {
    private List<Server> servers;
    private Queue<ResourceRequest> requestQueue;

    public void addServer(Server server) {
        if (!servers.contains(server)) {
            servers.add(server);
        } else {
            System.out.println("This server already exists in the DC");
        }
    }

    public void removeServer(Server server) {
        if (servers.removeIf(s -> s.equals(server))) {
            System.out.println("The server removed successfully from the the DC");
        } else {
            System.out.println("The DC doesn't include this server");
        }
    }

    public double getTotalEnergyConsumption() {
        return servers.stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public double getTotalFreeResources() {
        return servers.stream().mapToDouble(Server::getMaxLoad).sum()
                - servers.stream().mapToDouble(Server::getLoad).sum();
    }

    public double getTotalLoad() {
        return servers.stream().mapToDouble(Server::getLoad).sum();
    }

    public void allocateResources(ResourceRequest request) {
        if (!checkOpportunityForAllocate(request)) {
            requestQueue.add(request);
            System.out.println("Unfortunately, the DC hasn't enough resources now. " +
                    "But don't worry, your request will be processed later");
            return;
        }

        servers.sort(Comparator.comparing(Server::getEnergyConsumption));

        for (Server server : servers) {
             if (server.tryAllocateResources(request)) {
                System.out.println("The resources allocated successfully");
                return;
            }
            request.setLoad(request.getLoad() - server.loadMax());
        }
    }

    private void releaseResources(ResourceRequest request) {
        if (!checkOpportunityForRelease(request)) {
            System.out.println("DC releases maximum resources, but not enough for this request");
        }

        servers.sort(Comparator.comparing(Server::getEnergyConsumption).reversed());
        for (Server server : servers) {
            if (server.tryReleaseResources(request)) {
                System.out.println("The resources released successfully");
                return;
            }
            request.setLoad(request.getLoad() - server.releaseMax());
        }
    }

//    private void optimizeResources(ResourceRequest request) {
//        servers.sort(Comparator.comparing(Server::getEnergyConsumption).reversed());
//        for (int i = 0; i < servers.size(); i++) {
//            for (int j = servers.size() - 1; j > i; j--) {
//                if (servers.get(i).redistributeTo(servers.get(j))) {
//                    break;
//                }
//            }
//        }
//    }

    private boolean checkOpportunityForAllocate(ResourceRequest request) {
        return getTotalFreeResources() >= request.getLoad();
    }

    private boolean checkOpportunityForRelease(ResourceRequest request) {
        return getTotalLoad() >= request.getLoad();
    }

    public DataCenterService (DataCenter dataCenter) {
        this.servers = dataCenter.getServers();
    }
}
