package faang.school.godbless.datacenter;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService service = new DataCenterService(dataCenter);

        Server server1 = new Server(100.0, 200.0);
        Server server2 = new Server(100.0, 150.0);
        Server server3 = new Server(100.0, 250.0);

        service.addServer(server1);
        service.addServer(server2);
        service.addServer(server3);

        // ���������� ������� �� �������
        ResourceRequest request = new ResourceRequest(50.0);
        if (!service.allocateResources(request)) {
            System.out.println("Failed to allocate resources.");
        }

        // �������� ��������� �������� �� �����������
        System.out.println("Before Optimization:");
        printServerLoads(dataCenter);

        // ���������� ��������� ����������� ��������
        service.setOptimizationStrategy(new LoadBalancingOptimizationStrategy());
        service.optimizeLoad();

        // �������� ��������� �������� ����� �����������
        System.out.println("After Load Balancing Optimization:");
        printServerLoads(dataCenter);

        // ������������ ��������
        if (!service.releaseResources(request)) {
            System.out.println("Failed to release resources.");
        }

        // �������� ��������� �������� ����� ������������ ��������
        System.out.println("After Releasing Resources:");
        printServerLoads(dataCenter);

        // ���������� ������ ��������� �����������
        service.setOptimizationStrategy(new EnergyEfficencyOptimizationStrategy());
        service.optimizeLoad();

        // �������� ��������� �������� ����� ������ �����������
        System.out.println("After Energy Efficiency Optimization:");
        printServerLoads(dataCenter);

        // ������ ������ �����������������
        System.out.println("Total Energy Consumption: " + service.getTotalEnergyConsumption());
    }

    private static void printServerLoads(DataCenter dataCenter) {
        int i = 1;
        for (Server server : dataCenter.getServers()) {
            System.out.println("Server " + i + " Load: " + server.getLoad());
            i++;
        }
    }
}