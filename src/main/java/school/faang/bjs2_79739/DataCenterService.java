package school.faang.bjs2_79739;

import java.util.concurrent.atomic.AtomicInteger;

public class DataCenterService {
    public static final AtomicInteger ID = new AtomicInteger();

    //Все методы сделать статичными? Тут нет состояний/свойств у объектов. Данные передаются через аргументы ф-ций
    public void addServer(DataCenter dataCenter, Server server) {
        if (server.getId() == null) {
            server.setId(ID.incrementAndGet());
        }
        dataCenter.getServers().add(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        if (!dataCenter.getServers().remove(server)) {
            System.out.println("Сервер не найден");
            server.setId(null);
        }
    }

    public static double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getServers().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double remain = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (availableLoad > 0) {
                double reserve = Math.min(availableLoad, remain);
                server.setLoad(server.getLoad() + reserve);
                remain -= reserve;
            }
            if (remain <= 0) {
                return true;
            }
        }
        return false;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double remain = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double loadReduction = Math.min(server.getLoad(), remain);
            server.setLoad(server.getLoad() - loadReduction);
            remain -= loadReduction;
            if (remain <= 0) {
                return;
            }
        }
        System.out.println("Не удалось снять нагрузку");
    }

    public void optimize(DataCenter dataCenter, OptimizationStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Не передана стратегия оптимизации");
        }
        strategy.optimize(dataCenter);
    }
}
