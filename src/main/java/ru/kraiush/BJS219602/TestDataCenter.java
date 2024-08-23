package ru.kraiush.BJS219602;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestDataCenter {

    public static void main(String[] args) {

        DataServers dataCenter = new DataServers();

        List<Server> servers = dataCenter.getServers();

        DataCenterService dataService = new DataCenterService();

        dataService.addServer(servers, servers.size() + 1, 500, 5000);

        ResourceRequest request = new ResourceRequest();

        System.out.println("Common consuming energy: " + dataService.getTotalEnergyConsumption(servers));

        final int iter = 5;
        double[] loads;
        List<Integer> listOverload;
        List<Integer> sumOverload = new ArrayList<>(Collections.nCopies(servers.size(), 0));

        for (int i = 0; i < iter; i++) {
            System.out.println("\n <-- resouces loading --->");
            loads = request.getLoad(servers.size());
            listOverload = dataService.load(dataCenter, loads);
            for (int j = 0; j < listOverload.size(); j++) {
                if (listOverload.get(j) != 0) {
                    sumOverload.set(j, sumOverload.get(j) + 1);
                }
            }
            System.out.println("     <--- servers loading: --->");
            System.out.println(servers);
        }
        System.out.println("Overloading list: ");
        System.out.println(Arrays.toString(sumOverload.toArray()));


        System.out.println("\nOptimize resources");

        Optimize optimize = new Optimize(dataCenter, sumOverload);
        optimize.optimyzeMethod(new LoadBalancingOptimizationStrategy(dataCenter, sumOverload));

        optimize.optimyzeMethod(new EnergyEfficencyOptimizationStrategy(dataCenter, sumOverload));

        sumOverload.replaceAll(ignored -> 0);

        for (int i = 0; i < iter; i++) {
            System.out.println("\n <-- resouces loading --->");
            loads = request.getLoad(servers.size());
            listOverload = dataService.load(dataCenter, loads);
            for (int j = 0; j < listOverload.size(); j++) {
                if (listOverload.get(j) != 0) {
                    sumOverload.set(j, sumOverload.get(j) + 1);
                }
            }
            System.out.println("     <--- servers loading: --->");
            System.out.println(servers);
        }
        System.out.println("\n <--- Overloading list ---> ");
        System.out.println(Arrays.toString(sumOverload.toArray()));
    }
}
