package faang.school.godbless.BJS2_19329;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double allSrvLoad = dataCenter.getServersList().stream().mapToDouble(Server::getLoad).sum();
        int bigSrvCount = (int) (allSrvLoad / dataCenter.getLARGE_SERVER());
        if (bigSrvCount > 0) {
            dataCenter.getServersList().clear();
            for (int i = 0; i < bigSrvCount; i++) {
                Server server = new Server(dataCenter.getLARGE_SERVER());
                server.setLoad(dataCenter.getLARGE_SERVER());
                dataCenter.getServersList().add(server);
            }
            allSrvLoad -= bigSrvCount * dataCenter.getLARGE_SERVER();
        }
        if (allSrvLoad > 0) {
            if (allSrvLoad >= dataCenter.getMEDIUM_SERVER()) {
                Server server = new Server(dataCenter.getMEDIUM_SERVER());
                server.setLoad(allSrvLoad);
                dataCenter.getServersList().add(server);
            }
            Server server = new Server(dataCenter.getSMALL_SERVER());
            server.setLoad(allSrvLoad);
            dataCenter.getServersList().add(server);
        }
    }
}