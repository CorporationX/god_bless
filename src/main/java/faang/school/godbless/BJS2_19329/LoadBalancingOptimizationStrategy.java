package faang.school.godbless.BJS2_19329;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        double allSrvMaxLoad = dataCenter.getServersList().stream().mapToDouble(Server::getMaxLoad).sum();
        double allSrvLoad = dataCenter.getServersList().stream().mapToDouble(Server::getLoad).sum();
        double percentLoad = (double) Math.round(((allSrvLoad * 100 / allSrvMaxLoad) * 100)) / 100;
        for (Server server : dataCenter.getServersList()) {
            server.setLoad(server.getMaxLoad() * percentLoad / 100);
        }
        double currentSrvLoad = dataCenter.getServersList().stream().mapToDouble(Server::getLoad).sum();
        if (currentSrvLoad < allSrvLoad) {
            for (Server server : dataCenter.getServersList()) {
                double srvFreeLoad = server.getMaxLoad() - server.getLoad();
                double residualLoad = allSrvLoad - currentSrvLoad;
                if (srvFreeLoad > residualLoad) {
                    server.setLoad(server.getLoad() + residualLoad);
                    break;
                }
            }
        }
    }
}