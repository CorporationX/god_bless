package school.faang.bjs245016;

public class Main {
    public static void main(String[] args) {
        DataCenterService datacenterservice = new DataCenterService();
        datacenterservice.addServer("Server1", 10, 100, 10000);
        datacenterservice.addServer("Server2", 20, 200, 20000);
        datacenterservice.allocateResources(new ResourceRequest(85, null));
        datacenterservice.optimizeDatacenter("EnergyEfficiencyOptimizationStrategy");
    }
}
