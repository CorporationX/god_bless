package BJS2_19551;

public class DataCenterService {
    public void allocateResources(ResourceRequest resourceRequest, DataCenter dataCenter) {
        for (Server serverToFind : dataCenter.getServers()) {
            if (serverToFind.getLoad() + resourceRequest.getLoad() <= serverToFind.getMaxLoad()) {
                serverToFind.setLoad(serverToFind.getLoad() + resourceRequest.getLoad());
                System.out.println("Server to allocate " + resourceRequest.getLoad() + " was found!");
                System.out.println("Current load is " + serverToFind.getLoad());
            }
            break;
        }
    }

    public void releaseResources(ResourceRequest resourceRequest, DataCenter dataCenter) {
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
}
