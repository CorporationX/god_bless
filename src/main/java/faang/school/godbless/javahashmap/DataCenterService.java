package faang.school.godbless.javahashmap;

public class DataCenterService implements OptimizationStrategy{
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
        for (Server server : DataCenter.getServers()) {
            double availableCapacity = server.getMaxLoad() - server.getLoad();
            if (availableCapacity >= request.getLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
                server.setEnergyConsumption(server.getLoad() * 10 / server.getMaxLoad());
                return;
            }
        }
        System.out.println("Невозможно выделить ресурсы. Нет подходящего сервера.");
    }

    public static void releaseResources(ResourceRequest request) {
        for (Server server : DataCenter.getServers()) {
            double releaseAmount = Math.min(server.getLoad(), request.getLoad());
            server.setLoad(server.getLoad() - releaseAmount);
            server.setEnergyConsumption(server.getLoad() * 10 / server.getMaxLoad());
            request.setLoad(request.getLoad() - releaseAmount);
            if (request.getLoad() == 0) {
                return;
            }
        }
        System.out.println("Невозможно высвободить запрошенные ресурсы. Недостаточно выделенных ресурсов.");
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        while (true) {
            for (Server server: DataCenter.getServers()) {
                if (server.getLoad() > server.getMaxLoad()*0.8) {
                    server.setLoad(server.getLoad() * 0.9);
                    server.setEnergyConsumption(server.getLoad() * 10 / server.getMaxLoad());
                }
            }

            try {
                Thread.sleep(18*10^5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
