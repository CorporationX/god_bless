package faang.school.godbless;

import java.util.Map;

//Создать класс DataCenterService, в котором будут:
// Методы для добавления и удаления сервера;
// Метод для получения информации о потреблении электроэнергии всеми серверами (getTotalEnergyConsumption());
// Методы для выделения и высвобождения ресурсов на запрос
// (allocateResources(ResourceRequest request), releaseResources(ResourceRequest request)).
public class DataCenterService {
    public void addServer (DataCenter datacenter, String name, double maxLoad, double defaultEnergy) {
        datacenter.servers.put(name, new Server(0,maxLoad, defaultEnergy));
        datacenter.setTotalServers(datacenter.getTotalServers()+1);
    }
    public void removeServer (DataCenter datacenter, String name) {
        if (datacenter.servers.get(name) == null) {
            throw new RuntimeException("No such server");
        }
        if (datacenter.servers.get(name).getLoad() >
                (datacenter.countFreeRPS()-datacenter.servers.get(name).getMaxLoad()+datacenter.servers.get(name).getLoad())) {
            throw new RuntimeException("Not enough free RPS");
        }
        double loadToAdd = datacenter.servers.get(name).getLoad();
        datacenter.servers.remove(name);
        datacenter.setTotalServers(datacenter.getTotalServers()-1);
        datacenter.addResources(loadToAdd);
    }
    public void allocateResources(DataCenter datacenter,ResourceRequest request) {
        if (request.getLoad() > datacenter.countFreeRPS()) {
            throw new RuntimeException("Not enough free RPS");
        }
        datacenter.addResources(request.getLoad());
    }
    public void releaseResources(DataCenter datacenter, ResourceRequest request) {
        datacenter.removeResources(request.getLoad());
    }
    public static void main(String[] args) {
        DataCenterService datacenterService = new DataCenterService();
        DataCenter datacenter = new DataCenter();
        datacenterService.addServer(datacenter,"A",10000, 4300);
        datacenterService.addServer(datacenter,"B",8000, 3300);
        datacenterService.addServer(datacenter,"C",7000, 3000);
        datacenterService.addServer(datacenter,"D",6000, 2500);
        datacenterService.allocateResources(datacenter,new ResourceRequest(6000));
        datacenter.showResources();
        datacenterService.releaseResources(datacenter,new ResourceRequest(3000));
        datacenterService.removeServer(datacenter,"C");
        datacenter.showResources();
        LoadBalancingOptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();
        strategy.optimize(datacenter);
        datacenter.showResources();
    }

}
