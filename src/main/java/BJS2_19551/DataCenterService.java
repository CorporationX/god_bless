package BJS2_19551;

public class DataCenterService {
    public static void allocateResources(ResourceRequest resourceRequest, DataCenter dataCenter) {
        for (Server serverToFind : dataCenter.getServers()) {
            if (serverToFind.getLoad() + resourceRequest.getLoad() <= serverToFind.getMaxLoad()) {
                serverToFind.setLoad(serverToFind.getLoad() + resourceRequest.getLoad());
                System.out.println("Server to allocate " + resourceRequest.getLoad() + " was found!");
                System.out.println("Current load is " + serverToFind.getLoad());
            }
            break;
        }
    }

    public static void releaseResources(ResourceRequest resourceRequest, DataCenter dataCenter) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() - resourceRequest.getLoad() > 0) {
                server.setLoad(server.getLoad() - resourceRequest.getLoad());
                System.out.println("Successfully removed " + resourceRequest.getLoad()
                        + " from it's load");
                System.out.println("Current load is " + server.getLoad());
            }
            break;
        }
    }

    public static void medianOptimization(DataCenter mainDataCenter) {
        Optimization.implementOptimization(mainDataCenter, dataCenter -> {
            double medianLoad = DataCenter.getServersLoad(dataCenter) / dataCenter.getServers().size();
            System.out.println(medianLoad);
            for (Server server : dataCenter.getServers()) {
                if (server.getMaxLoad() > medianLoad) {
                    server.setLoad(medianLoad);
                    server.setEnergyConsumption(medianLoad / server.getMaxLoad());
                }
            }
        });
    }

}
