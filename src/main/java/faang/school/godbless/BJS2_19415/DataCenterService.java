package faang.school.godbless.BJS2_19415;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;

    public void addServer(Server server) {
        dataCenter.getCluster().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getCluster().remove(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.0;
        for (Server server : dataCenter.getCluster()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public double getTotalFreeLoad() {
        double totalFreeLoad = 0.0;
        for (Server server : dataCenter.getCluster()) {
            totalFreeLoad += server.getMaxLoad() - server.getLoad();
        }
        return totalFreeLoad;
    }

    private void checkAllocateResourcesLoad(double load) {
        if (load > getTotalFreeLoad()) {
            throw new IllegalArgumentException("Количество выделяемых ресурсов превышает количество неиспользуемой нагрузки кластера");
        }
    }

    private double getTotalLoad() {
        double totalLoad = 0.0;
        for (Server server : dataCenter.getCluster()) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    private void checkReleaseResourcesLoad(double load) {
        if (load > getTotalLoad()) {
            throw new IllegalArgumentException("Количество освобождаемых ресурсов превышает количество текущей нагрузки кластера");
        }
    }

    //добавляем значение нагрузки на серверах
    public void allocateResources(ResourceRequest request) {
        double requestLoadValue = request.getLoad();
        checkAllocateResourcesLoad(requestLoadValue);
        for (Server server : dataCenter.getCluster()) {
            requestLoadValue -= server.getMaxLoad() - server.getLoad();;
            if (requestLoadValue <= 0.0) {
                server.setLoad(server.getLoad() + requestLoadValue);
                break;
            } else {
                server.setLoadToMaxValue();
            }
        }
    }

    //убавляет значение нагрузки на серверах
    public void releaseResources(ResourceRequest request) {
        double requestsLoadValue = request.getLoad();
        checkReleaseResourcesLoad(requestsLoadValue);
        for (Server server : dataCenter.getCluster()) {
            requestsLoadValue -= server.getLoad();
            if (requestsLoadValue <= 0.0) {
                server.setLoad(server.getLoad() - requestsLoadValue);
                break;
            } else {
                server.setLoadToMinValue();
            }
        }
    }
}
