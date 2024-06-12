package faang.school.godbless.BJS28666;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DataCenterService {
    private DataCenter dataCenter;
    private List<Server> servers;
    private List<ResourceRequest> requestList;
    private OptimizationStrategy optimizationStrategy;

    public void addServer(Server server) {
        if (!servers.contains(server)) {
            servers.add(server);
            System.out.println("The server added successfully to the DC");
            tryProcessRequestQueue();
        } else {
            System.out.println("This server already exists in the DC");
        }
    }

    public void removeServer(Server server) {
        if (servers.removeIf(s -> s.equals(server))) {
            System.out.println("The server removed successfully from the DC");
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
        double needResources = request.getLoad();
        if (!checkOpportunityForAllocate(request)) {
            requestList.add(request);
            System.out.println("Unfortunately, the DC hasn't " + needResources + " now.\n" +
                    "But don't worry, your request will be processed later\n");
            return;
        }

        servers.sort(Comparator.comparing(Server::getEnergyConsumption));

        for (Server server : servers) {
             if (server.tryAllocateResources(request)) {
                System.out.println("The resources allocated successfully: " + needResources + "\n");
                return;
            }
            request.setLoad(request.getLoad() - server.loadMax());
        }
    }

    public void releaseResources(ResourceRequest request) {
        double needToRelease = request.getLoad();
        if (!checkOpportunityForRelease(request)) {
            System.out.println("DC releases only " + (needToRelease - request.getLoad()) +
                    " resources, but not enough for this request\n");
        }

        servers.sort(Comparator.comparing(Server::getEnergyConsumption).reversed());
        for (Server server : servers) {
            if (server.tryReleaseResources(request)) {
                System.out.println("The resources released successfully: " + needToRelease + "\n");
                tryProcessRequestQueue();
                return;
            }
            request.setLoad(request.getLoad() - server.releaseMax());
        }
    }

    private boolean checkOpportunityForAllocate(ResourceRequest request) {
        return getTotalFreeResources() >= request.getLoad();
    }

    private boolean checkOpportunityForRelease(ResourceRequest request) {
        return getTotalLoad() >= request.getLoad();
    }

    public void optimizeDataCenter() {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
            System.out.println("DataCenter is optimized successfully");
        }
    }

    public ScheduledExecutorService runOptimizationStrategy(OptimizationStrategy strategy, int secondsInterval) {
        optimizationStrategy = strategy;
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::optimizeDataCenter, 0, secondsInterval, TimeUnit.SECONDS);
        return scheduler;
    }


    public void printServers() {
        System.out.println("DataCenter consists of:");
        if (servers.isEmpty()) {
            System.out.println("There's no servers in the DC");
        }
        servers.forEach(System.out::println);
        System.out.println();
    }

    public DataCenterService (DataCenter dataCenter) {
        this.dataCenter = dataCenter;
        this.servers = dataCenter.getServers();
        requestList = new ArrayList<>();
    }

    private void tryProcessRequestQueue() {
        Iterator<ResourceRequest> iterator = requestList.iterator();
        while (iterator.hasNext()) {
            ResourceRequest request = iterator.next();
            if (!checkOpportunityForAllocate(request)) {
                continue;
            }
            System.out.println("request " + request + " from queue is process");
            allocateResources(request);
            iterator.remove();
        }
    }
}
