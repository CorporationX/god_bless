package faang.school.godbless.Strategy;

import faang.school.godbless.loadExceptions.ExcessLoadException;
import faang.school.godbless.loadExceptions.NegativeLoadException;
import lombok.Setter;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DataCenterService {
    private final DataCenter dataCenter;
    @Setter
    private OptimizationStrategy optimizationStrategy;


    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void startPeriodOptimization(int intervalInMinutes) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (optimizationStrategy != null) {
                    optimizationStrategy.optimize(dataCenter);
                }
            }
        }, 0, (long) intervalInMinutes * 60 * 1000);
    }

    public void startOptimization() {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        }

    }


    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public void listServers() {
        System.out.println("Current servers: " + dataCenter.getServers());
    }


    public void allocateResources(ResourceRequest request) {
        List<Server> servers = dataCenter.getServers();
        for (Server server : servers) {
            try {
                server.allocateLoad(request.getLoad());
                break;
            } catch (ExcessLoadException e) {
                //System.out.println("Сервер не может выполнить операцию" + e.getMessage());
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        List<Server> servers = dataCenter.getServers();
        for (Server server : servers) {
            try {
                server.releaseLoad(request.getLoad());
                break;
            } catch (ExcessLoadException | NegativeLoadException e) {
                //System.out.println("Сервер не может выполнить операцию" + e.getMessage());
            }
        }

    }
}
