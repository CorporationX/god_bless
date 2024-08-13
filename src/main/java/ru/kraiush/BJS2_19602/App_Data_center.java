package ru.kraiush.BJS2_19602;

import lombok.*;

import java.util.ArrayList;
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

        double[] loads;
        final int iter =5;

        for (int i = 0; i < iter; i++) {
            loads= request.getLoad(servers.size());
            dataService.optimize(dataCenter, loads);
            System.out.println("     <--- servers loading optimized --->");
            System.out.println(servers);
        }
    }
}
interface OptimizationStrategy {
    void optimize(DataCenter dataCenter, double[] loads);
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

@Getter @Setter @ToString
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

class DataCenterService implements OptimizationStrategy {

    public double getTotalEnergyConsumption(List<Server> servers) {
        return servers.stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public  void allocateResources(Server server, double maxLoad, double energyConsumption) {
//        public  void allocateResources(ResourceRequest request) {
        server.setLoad(maxLoad);
        server.setEnergyConsumption(energyConsumption);
    }

    public  void releaseResources(Server server, double maxLoad, double energyConsumption) {
        //        public  void releaseResources(ResourceRequest request) {
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
    public void optimize(DataCenter dataCenter, double[] loads) {

        List<Server> servers = dataCenter.getServers();

        System.out.println();
        double diffGlobal=0;
        double diffCurrent=0;
        for (int j = 0; j < loads.length; j++) {
            diffCurrent = (loads[j] + diffGlobal) - servers.get(j).getMaxLoad() ;
            System.out.println("j: " + j + " loads[j]: " + loads[j] + " diffCurrent: " + diffCurrent + " diffGlobal: " + diffGlobal );
//            System.out.println("j: " + j + " loads[j]: " + loads[j]);
            if(diffCurrent > 0) {
                servers.get(j).setLoad(servers.get(j).getMaxLoad());
                diffGlobal = diffCurrent;
            } else {
                diffGlobal = diffGlobal + loads[j];
                servers.get(j).setLoad(diffGlobal);
                diffGlobal = 0;
            }
        }
    }
}


