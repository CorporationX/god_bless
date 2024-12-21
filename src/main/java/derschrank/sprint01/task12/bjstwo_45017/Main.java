package derschrank.sprint01.task12.bjstwo_45017;

import derschrank.sprint01.task12.bjstwo_45017.optimization.EnergyEfficiencyOptimizationStrategy;
import derschrank.sprint01.task12.bjstwo_45017.servers.Server;
import derschrank.sprint01.task12.bjstwo_45017.servers.ServersPattern;

public class Main {

    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(new Server("S1"));
        dataCenterService.addServer(new Server("S2"));
        dataCenterService.addServer(new Server("S3"));
        dataCenterService.addServer(new Server("S4", ServersPattern.BAYKAL));
        dataCenterService.addServer(new Server("S5", ServersPattern.BAYKAL));
        dataCenterService.addServer(new Server("S6", ServersPattern.BAYKAL));
        dataCenterService.addServer(new Server("S7", ServersPattern.INTEL));
        dataCenterService.addServer(new Server("S8", ServersPattern.INTEL));
        dataCenterService.addServer(new Server("S9", ServersPattern.INTEL));

        System.out.println(dataCenterService);


        ResourceRequest request1 = new ResourceRequest(800);
        System.out.println("1) Starting new App1., need: " + request1);
        dataCenterService.allocateResources(request1);

        System.out.println(dataCenterService);


        ResourceRequest request2 = new ResourceRequest(1100);
        System.out.println("2) Starting new App2., need: " + request2);
        dataCenterService.allocateResources(request2);

        System.out.println(dataCenterService);



        System.out.println("3) Stopping new App1., need: " + request1);
        dataCenterService.releaseResources(request1);

        System.out.println(dataCenterService);


        System.out.println("4) Optimize 'LoadBalancingOptimizationStrategy' ");
        System.out.println("4.1) Starting new App1 and optimize: " + request1);
        dataCenterService.allocateResources(request1);
        dataCenterService.optimize();

        System.out.println(dataCenterService);

        ResourceRequest request3 = new ResourceRequest(250);
        System.out.println("4.2) Starting new App3 and optimize: " + request3);
        dataCenterService.allocateResources(request3);
        dataCenterService.optimize();

        System.out.println(dataCenterService);



        System.out.println("5) Optimize 'EnergyEfficiencyOptimizationStrategy' ");
        dataCenterService.resetAllServers();
        dataCenterService.setOptimizationStrategy(new EnergyEfficiencyOptimizationStrategy());

        System.out.println("5.1) Starting new App1 and optimize: " + request1);
        dataCenterService.allocateResources(request1);
        dataCenterService.optimize();

        System.out.println(dataCenterService);

        System.out.println("5.2) Starting new App3 and optimize: " + request3);
        dataCenterService.allocateResources(request3);
        dataCenterService.optimize();

        System.out.println(dataCenterService);



    }
}
