package faang.school.godbless.BJS2_4282;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DataCenterService implements OptimizationStrategy {

    private static final Integer DEFAULT_INDEX_SERVER = 0;

    private final DataCenter dataCenter;
    private final Timer timer = new Timer();

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                optimize(dataCenter);
            }
        }, 0, 30 * 60 * 1000);
    }

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Long id) {
        List<Server> server = dataCenter.getServers().stream()
                .filter(server1 -> server1.getId().equals(id)).toList();
        if (server.isEmpty()) {
            throw new IllegalArgumentException("Server not found");
        }
        dataCenter.getServers().removeAll(server);
    }

    public void getTotalEnergyConsumption() {
        validateServers();
        int totalEnergyConsumption = DEFAULT_INDEX_SERVER;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getDoubleEnergyConsumption();
        }
        System.out.println("Total energy consumption: " + totalEnergyConsumption);
    }

    public void getAllInfo() {
        validateServers();
        System.out.println(dataCenter.getServers());
    }

    public void allocateResources(ResourceRequest resourceRequest) {
        validateServers();
        List<Server> freeServer = dataCenter.getServers().stream()
                .filter(server -> server.getDoubleLoad() < 80).toList();
        if (!freeServer.isEmpty()) {
            freeServer.get(DEFAULT_INDEX_SERVER).allocateResources(resourceRequest);
        } else {
            System.err.println("The servers are overloaded");
        }
    }

    public void releaseResources(ResourceRequest resourceRequest) {
        validateServers();
        dataCenter.getServers().get(DEFAULT_INDEX_SERVER).removeDoubleLoad(resourceRequest);
    }


    @Override
    public void optimize(DataCenter dataCenter) {
        validateServers();
        int totalDataLoad = DEFAULT_INDEX_SERVER;
        for (Server server : dataCenter.getServers()) {
            totalDataLoad += server.getDoubleLoad();
        }
        int avgDataLoad = averageTotal(totalDataLoad);
        if (avgDataLoad >= 80) {
            addServer(new Server());
        }
        avgDataLoad = averageTotal(totalDataLoad);
        for (Server server : dataCenter.getServers()) {
            server.setDoubleLoad(avgDataLoad);
        }
        System.out.println("Оптимизация в: " + LocalDateTime.now());
    }

    private int averageTotal(int totalDataLoad) {
        return totalDataLoad / dataCenter.getServers().size();
    }

    private void validateServers() {
        if (dataCenter.getServers().isEmpty()) {
            throw new IllegalArgumentException("Servers not be empty");
        }
    }
}
