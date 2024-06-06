package faang.school.godbless.BJS2_8534;

public class DataCenterService implements OptimizationStrategy {
  DataCenter dataCenter;

  public void addServer(Server server) {
    dataCenter.getServers().add(server);
  }

  public void removeServer(Server server) {
    dataCenter.getServers().remove(server);
  }

  public double getTotalEnergyConsumption() {
    return dataCenter.getServers().stream().map(Server::getLoad).reduce(Double::sum).orElse(0d);
  }

  public void allocateResources(ResourceRequest request) {
    for (Server server : dataCenter.getServers()) {
      if (server.getMaxLoad() - server.getLoad() >= request.getLoad()) {
        server.setLoad(server.getLoad() + request.getLoad());
        return;
      }
    }
  }

  public void releaseResources(ResourceRequest request) {
    for (Server server : dataCenter.getServers()) {
      if (server.getLoad() - request.getLoad() >= 0) {
        server.setLoad(server.getLoad() - request.getLoad());
        return;
      }
    }
  }

  @Override
  public void optimize(DataCenter dataCenter) {
    for (Server server : dataCenter.getServers()) {
      server.setLoad(getTotalEnergyConsumption() / dataCenter.getServers().size());
    }
  }
}
