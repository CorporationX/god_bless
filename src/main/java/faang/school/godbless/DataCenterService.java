package faang.school.godbless;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
            if(serverList.contains(id)){
                if(server.getMaxLoad() > server.getLoad() + request.getLoad()){
                    server.setLoad(server.getLoad() + request.getLoad());
                } else System.out.println("Load is too high");
            }
        }
    }

    public void releaseResources(List<Server> serverList, ResourceRequest request, int id){
        for (Server server : serverList){
            if(serverList.contains(id)){
                server.setLoad(0);
                System.out.println("Load is reset to zero");
            } else System.out.println("Not found the server");
        }
    }

    public void optimizeLoadPeriodically(DataCenter dataCenter, OptimizationStrategy strategy, long periodMillis) {
        Timer timer = new Timer(true);
        TimerTask optimizationTask = new TimerTask() {
            @Override
            public void run() {
                strategy.optimize(dataCenter);
            }
        };

        timer.scheduleAtFixedRate(optimizationTask, 0, periodMillis);
    }
}
