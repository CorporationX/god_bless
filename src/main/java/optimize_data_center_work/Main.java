package optimize_data_center_work;

public class Main {
    public static void main(String[] args) {
        // Create servers
        Server server1 = new Server(100);
        Server server2 = new Server(150);
        Server server3 = new Server(200);

        // Create data center
        DataCenter dataCenter = new DataCenter();
        dataCenter.addServer(server1);
        dataCenter.addServer(server2);
        dataCenter.addServer(server3);

        // Create data center service with load optimization strategy
        DataCenterService dataCenterService = new DataCenterService(dataCenter, new LoadOptimizationStrategy());

        // Allocate resources
        ResourceRequest request1 = new ResourceRequest(80);
        dataCenterService.allocateResources(request1);

        // Print server loads
        for (Server server : dataCenter.getServers()) {
            System.out.println("Server Load: " + server.getLoad());
        }

        // Release resources
        dataCenterService.releaseResources(request1);

        // Print server loads after release
        for (Server server : dataCenter.getServers()) {
            System.out.println("Server Load: " + server.getLoad());
        }

        // Optimize load
        dataCenterService.optimizeLoad();
    }
}
