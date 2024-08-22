package ru.kraiush.BJS2_19602;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class App_Data_center {
    public static void main(String[] args) {

        DataCenter dataCenter = new DataCenter();

        List<Server> servers = dataCenter.getServers();

        DataCenterService dataService = new DataCenterService();

        dataService.addServer(servers, servers.size() + 1, 500, 5000);

        ResourceRequest request = new ResourceRequest();

        System.out.println("Common consuming energy: " + dataService.getTotalEnergyConsumption(servers));

        final int iter =5;
        double[] loads;
        List<Integer> listOverload;
        List<Integer> sumOverload=new ArrayList<>(Collections.nCopies(servers.size(), 0));

        for (int i = 0; i < iter; i++) {
            System.out.println("\n <-- resouces loading --->");
            loads= request.getLoad(servers.size());
            listOverload = dataService.load(dataCenter, loads);
            for (int j = 0; j < listOverload.size(); j++) {
                if(listOverload.get(j) != 0) {
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
            loads= request.getLoad(servers.size());
            listOverload = dataService.load(dataCenter, loads);
            for (int j = 0; j < listOverload.size(); j++) {
                if(listOverload.get(j) != 0) {
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
interface OptimizationStrategy {
    void optimize(DataCenter dataCenter, List<Integer> listOverload);

}
interface LoadStrategy {
    List<Integer> load(DataCenter dataCenter, double[] loads);

}
@Getter
@Setter
class Server {

    Integer id;
    double load;
    double maxLoad;
    double energyConsumption;

    public Server(int id, double maxLoad, double energyConsumption) {
        this.id = id;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public static List<Server> getServers() {
        List<Server> servers = new ArrayList<>();
        servers.add(new Server(1, 100, 1000));
        servers.add(new Server(2,   200, 2000));
        servers.add(new Server(3,  300, 3000));
        servers.add(new Server(4,  400, 4000));
        return servers;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", load=" + load + "}";
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class DataCenter  {

    List<Server> servers =  Server.getServers();
}
@Getter
@Setter
@ToString
class ResourceRequest  {
    public double[] getLoad(int servers) {

        double[] loads  = new double[servers];

        for (int i = 0; i < servers; i++) {
            loads[i]= ThreadLocalRandom
                    .current()
                    .nextDouble(1.0, 500);
        }
        return loads;
    }
}

class DataCenterService implements LoadStrategy {
    public double getTotalEnergyConsumption(List<Server> servers) {
        return servers.stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public  void allocateResources(Server server, double maxLoad, double energyConsumption) {
        server.setLoad(maxLoad);
        server.setEnergyConsumption(energyConsumption);
    }

    public  void releaseResources(Server server, double maxLoad, double energyConsumption) {
        server.setLoad(maxLoad);
        server.setEnergyConsumption(energyConsumption);
    }

    public List<Server> addServer(List<Server> servers, int id, double maxLoad, double energyConsumption) {

        if(servers == null) {
            return null;
        }
        servers.add(new Server(id, maxLoad, energyConsumption));
        return servers;
    }

    public void deleteServer(List<Server> servers, Integer id) {
        servers.removeIf(s -> s.getId().equals(id));
    }
    @Override
    public List<Integer> load(DataCenter dataCenter, double[] loads) {

        List<Server> servers = dataCenter.getServers();
        List<Integer> listOverload=new ArrayList<>(Collections.nCopies(servers.size(), 0));

        double diffGlobal=0;
        double diffCurrent;
        for (int j = 0; j < loads.length; j++) {
            diffCurrent = (loads[j] + diffGlobal) - servers.get(j).getMaxLoad() ;
//            System.out.println("j: " + j + " loads[j]: " + loads[j] + " diffCurrent: " + diffCurrent + " diffGlobal: " + diffGlobal );
            System.out.println("j: " + j + " loads[j]: " + loads[j]);
            if(diffCurrent > 0) {
                servers.get(j).setLoad(servers.get(j).getMaxLoad());
                diffGlobal = diffCurrent;
                listOverload.set(j, 1);
            } else {
                diffGlobal = diffGlobal + loads[j];
                servers.get(j).setLoad(diffGlobal);
                diffGlobal = 0;
            }
        }
        return listOverload;
    }
}
class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    DataCenter dataCenter;
    List<Integer> listOverload;

    public LoadBalancingOptimizationStrategy(DataCenter dataCenter, List<Integer> listOverload) {
        this.dataCenter = dataCenter;
        this.listOverload = listOverload;
    }

    @Override
    public void optimize(DataCenter dataCenter, List<Integer> listOverload) {

        List<Server> servers = dataCenter.getServers();

        for (int i = 0; i < servers.size(); i++) {
            if (listOverload.get(i) != 0) {
                servers.get(i).setMaxLoad(servers.get(i).getMaxLoad() * 2);
            }
        }
    }
}

class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {

    DataCenter dataCenter;
    List<Integer> listOverload;

    public EnergyEfficencyOptimizationStrategy(DataCenter dataCenter, List<Integer> listOverload) {
        this.dataCenter = dataCenter;
        this.listOverload = listOverload;
    }

    @Override
    public void optimize(DataCenter dataCenter, List<Integer> listOverload) {

        List<Server> servers = dataCenter.getServers();

        for (int i = 0; i < servers.size(); i++) {
            if (listOverload.get(i) != 0) {
                servers.get(i).setEnergyConsumption(servers.get(i).getEnergyConsumption() * 2);
            }
        }
    }
}
class Optimize {

    DataCenter dataCenter;
    List<Integer> listOverload;

    public Optimize(DataCenter dataCenter, List<Integer> listOverload) {
        this.dataCenter = dataCenter;
        this.listOverload = listOverload;
    }
    public void optimyzeMethod(OptimizationStrategy method) {
        method.optimize(dataCenter, listOverload);
    }
}

