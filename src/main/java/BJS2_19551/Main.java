package BJS2_19551;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static DataCenter dataCenter = new DataCenter(new ArrayList<>());
    private static DataCenterService dataCenterService = new DataCenterService();

    public static void main(String[] args) {
        dataCenter.getServerList().add(new Server(20, 100, (double) 20 / 100));
        dataCenter.getServerList().add(new Server(5, 75, (double) 5 / 75));
        dataCenter.getServerList().add(new Server(35, 150, (double) 35 / 150));
        dataCenter.getServerList().add(new Server(10, 90, (double) 10 / 90));
        dataCenter.getServerList().add(new Server(60, 70, (double) 60 / 70));

        Server serverTest = new Server(10, 50, (double) 10 / 50);
        //Add Server to list
        DataCenterService.addServer(serverTest, dataCenter);
        //removeServer from list
        DataCenterService.removeServer(serverTest, dataCenter);
        //Print total energy consumption of all servers
        DataCenterService.getTotalEnergyConsumption(dataCenter);
        //Allocate free space to load requested load
        DataCenterService.allocateResources(new ResourceRequest(30), dataCenter);
        //Release resource requested in Resource request
        DataCenterService.releaseResources(new ResourceRequest(30), dataCenter);

        System.out.println("Load before optimization = ");
        for (Server server : dataCenter.getServerList()) {
            System.out.println(server.getLoad());
        }
        //Running runOptimize every 30 minutes
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(Main::runOptimize, 0, 30, TimeUnit.MINUTES);
    }

    //Optimization method
    public static void runOptimize() {
        dataCenterService.optimize(dataCenter);
        System.out.println("Current load on all servers :");
        for (Server server : dataCenter.getServerList()) {
            System.out.println(server.getLoad());
        }
    }
}
