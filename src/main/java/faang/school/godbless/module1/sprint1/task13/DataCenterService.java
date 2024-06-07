package faang.school.godbless.module1.sprint1.task13;


public class DataCenterService implements OptimizationStrategy {
    public static final int HIGHEST_ACCEPT_LOAD = 90;
    public static final int LOWERS_ACCEPT_LOAD = 10;


    public void getTotalEnergyConsumption(DataCenter dataCenter) {
        int totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += (int) server.getEnergyConsumption();
        }
        System.out.println(totalEnergyConsumption);
    }

    public void allocateResources(ResourceRequest request, DataCenter dataCenter) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() + request.getLoad() < HIGHEST_ACCEPT_LOAD) {
                server.setLoad(server.getLoad() + request.getLoad());
                break;
            }
        }
        optimize(dataCenter);

    }

    public void releaseResources(ResourceRequest request, DataCenter dataCenter) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() - request.getLoad() > LOWERS_ACCEPT_LOAD) {
                server.setLoad(server.getLoad() - request.getLoad());
                break;
            }
        }
        optimize(dataCenter);

    }


    @Override
    public void optimize(DataCenter dataCenter) {
        int totalLoadOfServers = 0;
        for (Server server : dataCenter.getServers()) {
            totalLoadOfServers += (int) server.getLoad();
        }
        if (totalLoadOfServers / dataCenter.getServers().size() >= HIGHEST_ACCEPT_LOAD) {
            dataCenter.getServers().add(new Server());
        } else if (totalLoadOfServers / dataCenter.getServers().size() <= LOWERS_ACCEPT_LOAD) {
            dataCenter.getServers().remove(dataCenter.getServers().size() - 1);
        }
        for (Server server : dataCenter.getServers()) {
            server.setLoad((double) totalLoadOfServers / dataCenter.getServers().size());
        }

    }

}

