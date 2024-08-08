package BJS2_19551;

public class DataCenterService implements OptimizationStrategy {
    public static void addServer(Server server, DataCenter dataCenter) {
        dataCenter.getServerList().add(server);
        System.out.println("Server was added to server list with parameters : ");
        System.out.println(server.getLoad() + " current load");
        System.out.println(server.getMaxLoad() + " maximum load");
        System.out.println(server.getEnergyConsumption() + " energy consumption");
    }

    public static void removeServer(Server server, DataCenter dataCenter) {
        dataCenter.getServerList().remove(server);
        System.out.println("Server was successfully removed!");
    }

    public static void getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergyConsumption = 0;

        for (Server server : dataCenter.getServerList()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        System.out.println("Total energy consumption : " + totalEnergyConsumption + " kwt/h");
    }

    public static void allocateResources(ResourceRequest resourceRequest, DataCenter dataCenter) {
        for (Server serverToFind : dataCenter.getServerList()) {
            if (serverToFind.getLoad() + resourceRequest.getLoad() <= serverToFind.getMaxLoad()) {
                serverToFind.setLoad(serverToFind.getLoad() + resourceRequest.getLoad());
                System.out.println("Server to allocate " + resourceRequest.getLoad() + " was found!");
                System.out.println("Current load is " + serverToFind.getLoad());
            }
            break;
        }
    }

    public static void releaseResources(ResourceRequest resourceRequest, DataCenter dataCenter) {
        for (Server server : dataCenter.getServerList()) {
            if (server.getLoad() - resourceRequest.getLoad() > 0) {
                server.setLoad(server.getLoad() - resourceRequest.getLoad());
                System.out.println("Successfully removed " + resourceRequest.getLoad()
                        + " from it's load");
                System.out.println("Current load is " + server.getLoad());
            }
            break;
        }
    }

    public static double getServersLoad(DataCenter dataCenter) {
        double fullLoad = 0;
        for (Server server : dataCenter.getServerList()) {
            fullLoad += server.getLoad();
        }
        return fullLoad;
    }

    //Оптимизация ресурсов - собираем усредненную загрузку по всем серверам
    //присваиваем ее всем серверам, не оптимально , но для примера)
    @Override
    public void optimize(DataCenter dataCenter) {
        double medianLoad = getServersLoad(dataCenter) / dataCenter.getServerList().size();
        System.out.println(medianLoad);
        for (Server server : dataCenter.getServerList()) {
            if (server.getMaxLoad() > medianLoad) {
                server.setLoad(medianLoad);
                server.setEnergyConsumption(medianLoad / server.getMaxLoad());
            }
        }
    }
}
