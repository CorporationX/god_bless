package faang.school.godbless;

import java.util.*;

public class DataCenterService implements OptimizationStrategy {
    public static ArrayList<Server> addServer(ArrayList<Server> listOfServers, Server server){
        listOfServers.add(server);
        return listOfServers;
    }
    public static ArrayList<Server> deleteServer(ArrayList<Server> listOfServers, Server server){
        listOfServers.remove(server);
        return listOfServers;
    }
    public static double getTotalEnergyConsumption(DataCenter dataCenter){
        double totalEnergyConsumption = 0.0;
        for (Server server : dataCenter.listOfServers) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }
    public static void allocateResources(ResourceRequest request, DataCenter dataCenter){
        double[] freeLoad = new double[dataCenter.listOfServers.size()];
        for (int i = 0; i < dataCenter.listOfServers.size(); i++) {
            freeLoad[i] = dataCenter.listOfServers.get(i).getMaxLoad()-dataCenter.listOfServers.get(i).getLoad();
        }
        double sumOfFreeLoad = 0;
        for (double element : freeLoad) {
            sumOfFreeLoad += element;
        }
        double distributeLoad = request.getLoad();
        if(sumOfFreeLoad>=distributeLoad) {
            while (distributeLoad > 0) {
                for (int i = 0; i < dataCenter.listOfServers.size(); i++) {
                    if (freeLoad[i] > 0) {
                        double allocatedLoad = Math.min(distributeLoad, freeLoad[i]);
                        dataCenter.listOfServers.get(i).setLoad(allocatedLoad + dataCenter.listOfServers.get(i).getLoad());
                        freeLoad[i] -= allocatedLoad;
                        distributeLoad -= allocatedLoad;
                    }
                }
            }
        } else{
            System.out.println("There are not enough free load");
        }
    }
    public static void releaseResources(ResourceRequest request, DataCenter dataCenter){
        double[] load = new double[dataCenter.listOfServers.size()];
        for (int i = 0; i < dataCenter.listOfServers.size(); i++) {
            load[i] = dataCenter.listOfServers.get(i).getLoad();
        }
        double distributeLoad = request.getLoad();
        while (distributeLoad > 0) {
            for (int i = 0; i < dataCenter.listOfServers.size(); i++) {
                if (load[i] > 0) {
                    double allocatedLoad = Math.min(distributeLoad, load[i]);
                    dataCenter.listOfServers.get(i).setLoad(dataCenter.listOfServers.get(i).getLoad() - allocatedLoad);
                    load[i] -= allocatedLoad;
                    distributeLoad -= allocatedLoad;
                    }
                }
            }
        }

    @Override
    public void optimize(DataCenter dataCenter) {
        double[] freeLoad = new double[dataCenter.listOfServers.size()];
        for (int i = 0; i < dataCenter.listOfServers.size(); i++) {
            freeLoad[i] = dataCenter.listOfServers.get(i).getMaxLoad() - dataCenter.listOfServers.get(i).getLoad();
        }
        double sumOfLoad = 0.0;
        for (Server server : dataCenter.listOfServers) {
            sumOfLoad += server.getLoad();
        }
        Iterator<Server> iterator = dataCenter.listOfServers.iterator();
        while (iterator.hasNext()) {
            Server server = iterator.next();
                double fillLoad = Math.min(server.getMaxLoad(), sumOfLoad);
                sumOfLoad -= fillLoad;
                server.setLoad(fillLoad);
                if (server.getLoad() == 0) {
                    iterator.remove();
                }
        }
    }
}
