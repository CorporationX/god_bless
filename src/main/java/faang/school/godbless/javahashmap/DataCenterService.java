package faang.school.godbless.javahashmap;

public class DataCenterService {
    public static void addServer(Server server) {
        DataCenter.getServers().add(server);
    }

    public static void removeServer(Server server) {
        DataCenter.getServers().remove(server);
    }

    public static int getTotalEnergyConsumption() {
        int result = 0;

        for (Server server: DataCenter.getServers()) {
            result += server.getEnergyConsumption();
        }

        return result;
    }

    public static void allocateResources(ResourceRequest request) {

    }
}
