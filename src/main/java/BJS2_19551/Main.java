package BJS2_19551;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final DataCenter dataCenter = new DataCenter(new ArrayList<>());
    private static final LoadBalancingOptimizationStrategy loadBalancingOptimizationStrategy =
            new LoadBalancingOptimizationStrategy();
    private static final DataCenterService dataCenterService = new DataCenterService();

    public static void main(String[] args) {
        dataCenter.getServers().add(new Server(20, 100, (double) 20 / 100));
        dataCenter.getServers().add(new Server(5, 75, (double) 5 / 75));
        dataCenter.getServers().add(new Server(35, 150, (double) 35 / 150));
        dataCenter.getServers().add(new Server(10, 90, (double) 10 / 90));
        dataCenter.getServers().add(new Server(60, 70, (double) 60 / 70));

        Server serverTest = new Server(10, 50, (double) 10 / 50);
        //Add Server to list
        dataCenter.addServer(serverTest, dataCenter);
        //removeServer from list
        dataCenter.removeServer(serverTest, dataCenter);
        //Print total energy consumption of all servers
        dataCenter.getTotalEnergyConsumption(dataCenter);
        //Allocate free space to load requested load
        dataCenterService.allocateResources(new ResourceRequest(30), dataCenter);
        //Release resource requested in Resource request
        dataCenterService.releaseResources(new ResourceRequest(30), dataCenter);

        System.out.println("Load before optimization = ");
        for (Server server : dataCenter.getServers()) {
            System.out.println(server.getLoad());
        }
        //Running runOptimize every 5 seconds
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(Main::runOptimize, 0, 5, TimeUnit.SECONDS);
    }

    public static void runOptimize() {
        loadBalancingOptimizationStrategy.optimize(dataCenter);
        System.out.println("Current load on all servers :");
        for (Server server : dataCenter.getServers()) {
            System.out.println(server.getLoad());
        }
    }
}
