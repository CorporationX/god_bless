package school.faang.bjs2_69892;

import java.util.Timer;
import java.util.TimerTask;

public class DataCenterService {
    private final DataCenter dataCenter;
    private final OptimizationStrategy optimizationStrategy;
    private final Timer optimizationTimer = new Timer();

    public DataCenterService(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        this.optimizationStrategy = optimizationStrategy;
        this.dataCenter = dataCenter;
        startOptimizationTimer();
    }

    public void addServer(DataCenter dataCenter, Server server) {
        if (dataCenter == null || server == null) {
            throw new NullPointerException();
        }
        if (dataCenter.getServers().contains(server)) {
            throw new ServerAlreadyExistsException("Server with id " + server.getId() + " already exists");
        }
        dataCenter.getServers().add(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        if (dataCenter == null || server == null) {
            throw new NullPointerException();
        }
        if (!dataCenter.getServers().contains(server)) {
            throw new ServerNotFoundException("Server with id " + server.getId() + " not found");
        }
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public boolean allocateResources(DataCenter dataCenter, ResponseRequest request) {
        double remainLoad = request.load();
        for (Server server : dataCenter.getServers()) {
            if (remainLoad == 0) {
                break;
            }
            double remainServerLoad = server.getMaxLoad() - server.getLoad();
            if (remainServerLoad == 0) {
                continue;
            }
            double allocateServerLoad  = Math.min(remainServerLoad, remainLoad);
            server.setLoad(server.getLoad() + allocateServerLoad);
            remainLoad -= allocateServerLoad;
        }
        return remainLoad == 0;
    }

    public void releaseResources(DataCenter dataCenter, ResponseRequest request) {
        double remainLoad = request.load();
        for (Server server : dataCenter.getServers()) {
            if (remainLoad == 0) {
                break;
            }
            if (server.getLoad() == 0) {
                continue;
            }
            double remainServerLoad = server.getMaxLoad() - server.getLoad();
            double releaseServerLoad  = Math.min(remainServerLoad, remainLoad);
            server.setLoad(server.getLoad() - releaseServerLoad);
            remainLoad -= releaseServerLoad;
        }
    }

    private void startOptimizationTimer() {
        optimizationTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                optimizationStrategy.optimize(dataCenter);
            }
        }, 0, 1800000);
    }
}
