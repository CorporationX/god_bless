package faang.school.godbless;

import java.util.List;

public class DataCenterService {
    public void addServer(List<Server> serverList, int id, double load, double maxLoad, double energyConsumption){
        Server server = new Server(id, load, maxLoad, energyConsumption);
        serverList.add(server);
    }

    public void removeServer(List<Server> serverList, int id){
        if(serverList.contains(id)){
            serverList.remove(id);
            System.out.println("Deleted ");
        } else System.out.println("Not found :( ");
    }

    public void getTotalEnergyConsumption(List<Server> serverList){
        double total = 0;
        for(Server totalEnergyList : serverList){
            double consumption = totalEnergyList.getEnergyConsumption();
            total += consumption;
        }
        System.out.println("Total consumption of all servers = " + total);
    }

    public void allocateResources(List<Server> serverList, ResourceRequest request, int id){
        for(Server server : serverList){

        }
    }

    public void releaseResources(ResourceRequest request){

    }
}
