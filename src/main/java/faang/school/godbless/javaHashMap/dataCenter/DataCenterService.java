package faang.school.godbless.javaHashMap.dataCenter;

import lombok.Getter;

import java.util.List;

@Getter
public class DataCenterService implements OptimizationStrategy{
    private final DataCenter dataCenter;

    public DataCenterService() {
        dataCenter = new DataCenter();
    }

    public void allocateResources(ResourceRequest request) {
        for(Server server : dataCenter.getServers()) {
            if(server.takeLoad(request.getLoad())) {
                //Sever successfully took new load
                System.out.println("Resources were successfully allocated");
                return;
            }
        }

        System.out.println("There is no available servers to allocate these resources");
    }

    public void releaseResources(ResourceRequest request) {
        for(Server server : dataCenter.getServers()) {
            if(server.releaseLoad(request.getLoad())) {
                //Sever successfully released load
                System.out.println("Resources were successfully released");
                return;
            }
        }

        System.out.println("There is no loaded servers");
    }

    public boolean addServer(double maxLoad, double energyConsumption) {
        return dataCenter.getServers().add(new Server(0, maxLoad, energyConsumption));
    }

    public void removeServer(double load, double maxLoad, double energyConsumption) {
        List<Server> seversToBeRemoved = dataCenter.getServers().stream()
                .filter(server -> server.equals(
                        new Server(load, maxLoad, energyConsumption))
                ).toList();

        dataCenter.getServers().removeAll(seversToBeRemoved);
    }

    public void printAllServersInfo() {
        dataCenter.getServers().forEach(System.out::println);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.0;

        for(Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }

        return totalEnergyConsumption;
    }

    public double getTotalLoad() {
        double totalLoad = 0.0;

        for(Server server : dataCenter.getServers()) {
            totalLoad += server.getLoad();
        }

        return totalLoad;
    }

    //Чтобы этот метод рза в пол часа оптимизировал нагрузку,
    //его необходимо запустить в цикле в другом потоке с задержкой thread.sleep(30*60*1000)
    @Override
    public void optimize(DataCenter dataCenter) {
        double extraLoad = 0;
        for(Server server : dataCenter.getServers()) {
            if(server.isMaxLoaded()) {
                extraLoad += server.getExtraLoad();
                server.releaseLoad(server.getExtraLoad());

                continue;
            }

            double availableLoad = server.getAvailableLoad();

            if(availableLoad < extraLoad) {
                extraLoad -= availableLoad;
                server.takeLoad(availableLoad);

                continue;
            }

            server.takeLoad(extraLoad);
            extraLoad = 0;
        }
    }
}
