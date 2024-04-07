package faang.school.godbless.database_center;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DataCenterService implements OptimizationStrategy{
    private DataCenter dataCenter;
    private List<Server> serverList;

    public DataCenterService() {
        this.dataCenter = new DataCenter();
        this.serverList = new ArrayList<>();
    }

    public void addDataCenter(Server server) {
        serverList.add(server);
        updateAllServers(serverList);
    }

    public void removeServer(Server server) {
        serverList.remove(server);
        updateAllServers(serverList);
    }

    public void updateAllServers(List<Server> list) {
        dataCenter.setListOfServers(list);

    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.0;
        for (Server server : dataCenter.getListOfServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public List<Server> getServers() {
        return dataCenter.getListOfServers();
    }

    public void allocateResources(ResourceRequest request) {
        double loadResources = request.getLoad();

        Server minLoadServer = dataCenter.getListOfServers().get(0);
        double minLoad = minLoadServer.getLoad();

        for (Server server : dataCenter.getListOfServers()) {
            if (server.getLoad() < minLoad) {
                minLoadServer = server;
                minLoad = server.getLoad();
            }
        }

        double newLoad = minLoadServer.getLoad() + loadResources;
        minLoadServer.setLoad(newLoad);

        double updateEnergyConsumption = minLoadServer.getEnergyConsumption() + loadResources * 0.5;
        minLoadServer.setEnergyConsumption(updateEnergyConsumption);
    }

    public void releaseResources(ResourceRequest request) {
        double loadResources = request.getLoad();

        Server maxLoadServer = dataCenter.getListOfServers().get(0);
        double maxLoad = maxLoadServer.getLoad();

        for (Server server : dataCenter.getListOfServers()) {
            if (server.getLoad() > maxLoad) {
                maxLoadServer = server;
                maxLoad = server.getLoad();
            }
        }

        double newLoad = maxLoadServer.getLoad() - loadResources;
        if (newLoad < 0){
            newLoad = 0;
        }
        maxLoadServer.setLoad(newLoad);
    }

    @Override
    public void optimize() {

    }

    public  void scheduleTask() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                optimize();
                System.out.println("Выполнение кода каждые 30 минут");
            }
        };
        long delay = 0;
        long period = 30 * 60 * 1000;
        timer.scheduleAtFixedRate(task, delay, period);
    }
}
