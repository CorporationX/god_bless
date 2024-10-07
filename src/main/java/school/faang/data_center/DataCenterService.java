package school.faang.data_center;

import lombok.Data;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

@Data
public class DataCenterService implements OptimizationStrategy {
    private final DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    protected void addServerToDataCenter(Server server) {
        dataCenter.getServers().add(server);
    }

    protected void removeServerFromDataCenter(Server server) {
        dataCenter.getServers().remove(server);
    }

    protected double getTotalEnergyConsumption() {
        AtomicReference<Double> totalEnergy = new AtomicReference<>(0.0);
        dataCenter.getServers().forEach(server -> {
            totalEnergy.updateAndGet(atom -> (double) (atom + server.getEnergyConsumption()));
        });
        return totalEnergy.get();
    }

    protected void allocateResources(ResourceRequest request) {
        //сортируем чтобы получить сначала менее загруженные
        dataCenter.getServers().sort(Comparator.comparingDouble(Server::getLoad));
        double newResourceLoad = request.load();
        for (Server server : dataCenter.getServers()) {
            double valueLoad = server.getLoad();
            double maxValueLoad = server.getMAX_LOAD();
            double freeResourceOnServer = maxValueLoad - valueLoad;
            if (freeResourceOnServer >= newResourceLoad) {
                server.setLoad(valueLoad + newResourceLoad);
                break;
            } else {
                newResourceLoad = newResourceLoad - freeResourceOnServer;
                server.setLoad(freeResourceOnServer);
            }
        }
    }

    protected void releaseResources(ResourceRequest request) {
        //Сортируем, чтобы сначало освободить самые загруженные серверы
        dataCenter.getServers().sort(Comparator.comparingDouble(Server::getLoad).reversed());
        double releaseResource = request.load();
        for (Server server : dataCenter.getServers()) {
            double valueLoad = server.getLoad();
            if (valueLoad - releaseResource > 0) {
                server.setLoad(valueLoad - releaseResource);
                break;
            } else {
                releaseResource = releaseResource - valueLoad;
                server.setLoad(0);
            }
            if (releaseResource == 0) {
                break;
            }
        }

    }
}
